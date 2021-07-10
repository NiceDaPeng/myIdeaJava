package com.dpj.dynamic;

import com.dpj.proxy.User;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestJDKDynamic {

    public static void main(String[] args) {

        UserService service = new UserServiceImpl();

        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("---proxy log before---");
                Object ret = method.invoke(service,args);
                System.out.println("TestJDKDynamic.invoke log ---after");
                return ret;
            }
        };

        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(TestJDKDynamic.class.getClassLoader(), service.getClass().getInterfaces(),handler );
        userServiceProxy.regist(new User());
        userServiceProxy.login("linghuchong","111");
    }
}
