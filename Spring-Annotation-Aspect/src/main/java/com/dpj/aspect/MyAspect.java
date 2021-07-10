package com.dpj.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {

    @Pointcut("execution(* login(..))")
    public void myPointcut(){}

    @Around(value = "myPointcut()")
    public Object around(ProceedingJoinPoint joinPoint){
        Object ret = null;
        try {
            System.out.println("MyAspect.around---- log");
            ret = joinPoint.proceed();

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return ret;
    }

    @Around(value= "myPointcut()")
    public Object around1(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("MyAspect.around1 -- tx");
        Object ret  =joinPoint.proceed();
        return ret;
    }
}
