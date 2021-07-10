package iocdemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class TestMyClass {

    public static void main(String[] args) {

    }

    //设计一个方法用来实现IOC DI注入

    public static void setValue(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //根据字符串获取类的Class对象
        Class<?> clazz = Class.forName(className);
        Scanner input = new Scanner(System.in);
        //通过Class对象创建一个类对象
        Object obj = clazz.newInstance();
        //获取类中所有的属性
        Field[] fields = clazz.getDeclaredFields();
        //遍历每一个属性
        for (Field f:fields){
            //获取属性的名字
            String fieldName = f.getName();
            //获取属性的类型
            Class<?> fieldType = f.getType();
            //获取属性对应的set方法名
            String methodName = "set"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
            //根据方法名获取方法对象
            Method method = clazz.getMethod(methodName, fieldType);
            //获取键盘输入的值。
            System.out.println("请输入"+fieldName+"的值");
            String value = input.nextLine();
            //因为我们方法中的参数不一定都是String类型的，所以我们需要将类型构造为String类型
            //每一个包装类都有以一个构造方法是包含String类型的。
            Constructor<?> con = fieldType.getConstructor(String.class);
            Object o = con.newInstance(value);
            method.invoke(obj,o);
        }
    }
}
