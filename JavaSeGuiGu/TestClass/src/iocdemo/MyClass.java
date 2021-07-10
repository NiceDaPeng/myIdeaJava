package iocdemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class MyClass {


    //设计一个方法用来实现IOC DI

    public Object getBean(String className){
        Scanner input = new Scanner(System.in);
        Object o = null;
        try {
            //根据字符串获取Class对象。
            Class<?> clazz = Class.forName(className);
            //创建一个对象。
            o = clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for (Field f :
                    fields) {
                String fieldName = f.getName();
                Class<?> fieldType = f.getType();
                String str = fieldName.substring(0, 1);
                String firstString = str.toUpperCase();
                String endString = fieldName.substring(1);
                StringBuilder setName = new StringBuilder("set");
                setName.append(firstString);
                setName.append(endString);
                String methodName = setName.toString();
                Method method = clazz.getMethod(methodName,fieldType);
                System.out.println("请输入"+fieldName+"的值");
                String mes = input.nextLine();
                Constructor<?> con = fieldType.getConstructor(String.class);
                method.invoke(o,con.newInstance(mes));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {

        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return o;

    }
}
