package my.examples;

import my.examples.dao.IAccountDao;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAop {
    public static void main(String[] args) {
        SpringApplication.run(SpringAop.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(IAccountDao accountDao){
        return runner -> {
            // demoTheBeforeAdvice(accountDao);
            demoTheAfterReturningAdvice(accountDao);
        };
    }
     //@Before
    private void demoTheBeforeAdvice(IAccountDao accountDao) {
        accountDao.addAccount();
    }
     //@AfterReturning
    private void demoTheAfterReturningAdvice(IAccountDao accountDao) {
        accountDao.findAccounts();
    }
//

}
