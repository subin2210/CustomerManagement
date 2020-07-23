package com.study.spring.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

@Aspect
@Component
public class CrmAspect {

    private Logger logger = Logger.getLogger(getClass().getName());
    @Pointcut("execution(* com.study.spring.controller.*.*(..))")
    public void forController() {

    }

    @Pointcut("execution(* com.study.spring.service.*.*(..))")
    public void forService() {

    }

    @Pointcut("execution(* com.study.spring.dao.*.*(..))")
    public void forDao() {

    }

    @Pointcut("forController() || forService() || forDao()")
    public void forCustomerCrm() {}

    @Before("forCustomerCrm()")
    public void logBeforeAspect(JoinPoint joinPoint) {
         MethodSignature signature = (MethodSignature)joinPoint.getSignature();
         logger.info("Method called  = "+ signature);

         Object[] args = joinPoint.getArgs();

         for(Object arg : args) {
             logger.info("Argument = " + arg);
         }

         logger.info("Before Aspect for " + signature + "is completed");
    }

    @AfterReturning(pointcut = "forCustomerCrm()",returning = "result")
    public void logAfterAspect(JoinPoint joinPoint, Object result) {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        logger.info("After Returning AspectJ : Method called  = "+ signature);
        logger.info("After returning Aspect for " + signature + "result is.." + result);
    }
}
