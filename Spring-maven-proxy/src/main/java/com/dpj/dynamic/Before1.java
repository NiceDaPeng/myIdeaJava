package com.dpj.dynamic;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class Before1 implements MethodBeforeAdvice {
    /**
     * 这个方法的目的是运行在我们核心业务之前的方法，如果我们想在核心业务之前做一些事情
     * 那么可以将需要执行的代码方法before方法里面
     *
     * MehtodBeforeAdvice中的before方法中的三个参数解析：
     * Method：额外功能添加到哪个原始方法上面，method是变化的
     * 给哪个方法增加这个额外功能，method代表的就是哪个方法
     *
     *
     * Objects[]：是代表所增加给的原始方法的参数，
     *
     * Object 代表的是额外功能所增加给的原始对象，
     * @param method
     * @param objects
     * @param o
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("new UserServiceDynamic.before");
    }
}
