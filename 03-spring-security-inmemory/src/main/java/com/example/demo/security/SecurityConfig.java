package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    /**
     * by configuring this, spring security will not use
     * username and passwords from application.properties
     * @return
     */
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john = User.builder()
            .username("john")
            .password("{noop}test123")
            .roles("EMPLOYEE")
            .build();
        UserDetails scott = User.builder()
            .username("scott")
            .password("{noop}test123")
            .roles("EMPLOYEE","MANAGER")
            .build();
        UserDetails jane = User.builder()
            .username("jane")
            .password("{noop}test123")
            .roles("EMPLOYEE","MANAGER", "ADMIN")
            .build();
        return new InMemoryUserDetailsManager(john,scott,jane);
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
