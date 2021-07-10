package com.dpj.cglib;

import com.dpj.proxy.User;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TestCGlib {

    public static void main(String[] args) {

        UserService userService = new UserService();

        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(TestCGlib.class.getClassLoader());
        enhancer.setSuperclass(UserService.class);
        MethodInterceptor interceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("TestCGlib.intercept");
               Object ret =  method.invoke(userService,objects);
               return ret;
            }
        };
        enhancer.setCallback(interceptor);
        UserService serviceProxy = (UserService) enhancer.create();
        serviceProxy.login("linghuchong","111");
        serviceProxy.regist(new User());

    }
}
