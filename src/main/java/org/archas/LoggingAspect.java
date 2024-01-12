package org.archas;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* org.archas.ShoppingCart.checkout(..))")
    public void beforeLogger(JoinPoint joinPoint) {
        String string = joinPoint.getArgs()[0].toString();
        System.out.println("Before Loggers " + string);
    }

    @After("execution(* org.archas.ShoppingCart.checkout(..))")
    public void afterLogger() {
        System.out.println("After logger");
    }

    @Pointcut("execution(* org.archas.ShoppingCart.quantity())")
    public void afterReturningPointCut() {

    }


    @AfterReturning(pointcut = "afterReturningPointCut()", returning = "retVal")
    public void afterReturning(String retVal) {
        System.out.println("After Returning : " + retVal);
    }
}
