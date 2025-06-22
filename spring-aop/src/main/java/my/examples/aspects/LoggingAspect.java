package my.examples.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import my.examples.model.Account;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(3)
public class LoggingAspect {
    /**
     * point cut expression:
     * reusability of the expression is not there ====> pointcut decleration with @Pointcut annotation
     */
    // declaration of a pointcut
    // create a pointcut for all methods in dao package
    @Pointcut("execution(* my.examples.dao.*.*(..))")
    private void forDaoPackage(){};
    // create a pointcut for all getter methods in dao package
    @Pointcut("execution(* my.examples.dao.*.get*(..))")
    private void getter(){};
    // create a pointcut for all setter methods in dao package
    @Pointcut("execution(* my.examples.dao.*.set*(..))")
    private void setter(){};

    // create a pointcut to include all the methods in dao and exclude all the getters and setters
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void getDaoPackageWithoutGetterAndSetters(){};


    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice_pointcutExpression(){
        System.out.println("\n==============>>>>@Before Executing pointcutExpression advice on method addAccount");
    }

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice_pointcutDecleration(){
        System.out.println("\n==============>>>>@Before Executing pointcutDeclaration advice on method addAccount");
    }
    // reuse the pointcut declaration
    @Before("forDaoPackage()")
    public void apiAnalyticsAdvice_pointcutDecleration(){
        System.out.println("\n==============>>>>@Before Executing pointcutDeclaration api analytics on method addAccount");
    }
    @AfterReturning(pointcut = "forDaoPackage()", returning = "result")
    public void afterReturningAdvice_pointcutDeclaration(JoinPoint joinPoint, List<Account> result){
        // print out which for which method this advice is printing
        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("\n =====> @AfterReturning Executed on method: " + methodName);
        System.out.println("\n =====> result is: " + result);
    }
}
