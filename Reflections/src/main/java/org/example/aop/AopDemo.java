package org.example.aop;

import org.example.Main;
import org.example.aop.dao.AccountDao;
import org.example.aop.dao.IAccountDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopDemo {
    public static void main(String[] args) {
        SpringApplication.run(AopDemo.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(IAccountDao accountDao){
        return runner -> {
            // demoTheBeforeAdvice(accountDao);
            demoTheAfterReturningAdvice(accountDao);
        };
    }
    // @Before
    private void demoTheBeforeAdvice(IAccountDao accountDao) {
        accountDao.addAccount();
    }
    // @AfterReturning
    private void demoTheAfterReturningAdvice(IAccountDao accountDao) {
        accountDao.findAccounts();
    }


}
