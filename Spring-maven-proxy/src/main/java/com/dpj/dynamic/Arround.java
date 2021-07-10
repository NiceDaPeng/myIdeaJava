package com.dpj.dynamic;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class Arround implements MethodInterceptor {

    /**
     * MethodInvocation参数表示的原始的方法
     * Object：表示的原始方法执行后的返回值
     * @param methodInvocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Arround.invoke --原始方法执行之前执行了");
        //让原始方法执行
        Object ret = null;
        try {
            ret = methodInvocation.proceed();
        } catch (Throwable throwable) {
            System.out.println("Arround.invoke---原始方法抛出异常的时候执行");
            throwable.printStackTrace();
        }
        System.out.println("Arround.invoke ---原始方法执行只有执行");
        return ret;
    }
}
