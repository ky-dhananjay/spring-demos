package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    /**
     * METHOD:1
     * by configuring this, spring security will not use
     * username and passwords from application.properties
     * @return
     */
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails john = User.builder()
//            .username("john")
//            .password("{noop}test123")
//            .roles("EMPLOYEE")
//            .build();
//        UserDetails scott = User.builder()
//            .username("scott")
//            .password("{noop}test123")
//            .roles("EMPLOYEE","MANAGER")
//            .build();
//        UserDetails jane = User.builder()
//            .username("jane")
//            .password("{noop}test123")
//            .roles("EMPLOYEE","MANAGER", "ADMIN")
//            .build();
//        return new InMemoryUserDetailsManager(john,scott,jane);
//    }

    /**
     * METHOD: 2
     * add support for JDBC,no hardcoded users
     * this is for spring security suggested tables and schema
     * create table users and authorities to make this functional
     * @param dataSource
     * @return
     */

//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource){
//        return new JdbcUserDetailsManager(dataSource);
//    }
    /**
     * METHOD 3
     * custom user tables
     * @return
     * @throws Exception
     */
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
            "select user_id,pw,active from members where user_id=?");

        //define the query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
            "select user_id,role from roles where user_id=?"
        );
        return jdbcUserDetailsManager;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
            configurer ->
                configurer
                    .requestMatchers(HttpMethod.GET, "/api/employee").hasAnyRole("EMPLOYEE","MANAGER","ADMIN")
                    .requestMatchers(HttpMethod.GET, "/api/employee/**").hasAnyRole("EMPLOYEE","MANAGER","ADMIN")
                    .requestMatchers(HttpMethod.POST, "/api/employee").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.PUT, "/api/employee").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.DELETE, "/api/employee/**").hasRole("ADMIN")
        );
        //use basic authentication
        http.httpBasic();

        //disable CSRF(Cross site request forgery)
        // in general, not required for stateless REST APIs

        http.csrf().disable();

        return http.build();
    }
}
