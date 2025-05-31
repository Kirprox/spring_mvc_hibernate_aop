package com.zaurtregulov.spring.mvc_hibernate_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggingAspect {
    @Around("execution(* com.zaurtregulov.spring.mvc_hibernate_aop.dao.*.*(..))")
    public Object AroundAllRepositoryMethodAdvice(ProceedingJoinPoint pj) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) pj.getSignature();
        String methodName = methodSignature.getName();

        System.out.println("begin of " + methodName);
        Object targetMethodResult = pj.proceed();
        System.out.println("end of " + methodName);
        return targetMethodResult;
    }
}
