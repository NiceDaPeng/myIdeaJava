package ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class MySpring {

    //设计一个方法 帮我控制对象的创建
    //是否需要参数--需要给你一个字符串你给我个对象
    //是否需要返回值--返回值是一个对象。返回对象的类型可以设为Object
    public Object getBean(String className){

        Scanner input = new Scanner(System.in);
        System.out.println("请给类"+className+"的对象属性赋值");
        Object obj = null;
        try {
            //获取方法传递进来的参数对应的Class对象。
            Class<?> clazz = Class.forName(className);
            //通过clazz创建对象。
            obj = clazz.newInstance();
            //在这里做一个自动DI注入，将对象的所有属性值自动注入。
            //找寻属性对应的所有set方法给属性赋值。
            //自己通过拼接字符串的方式处理名字
            //1，先通过clazz找寻所有的私有属性，找它的目的是获取每一个属性的名字，
            //拿到这个名字是为了处理set方法的名字
            Field[] fields = clazz.getDeclaredFields();
            for (Field field :
                    fields) {
                //获取属性名
                String fieldName = field.getName();
                //拼串，拼接属性对应的set方法名,如属性名字角name set方法名字就是setName（）
                String firstLetter = fieldName.substring(0, 1).toUpperCase();
                String otherLetters = fieldName.substring(1);
                StringBuilder setMethodName = new StringBuilder("set");
                setMethodName.append(firstLetter);
                setMethodName.append(otherLetters);
                //获取field对应的属性名字的Class对象
                Class fieldClass = field.getType();
                //通过处理好的set方法名找寻属性对应的set方法
                Method setMethod = clazz.getMethod(setMethodName.toString(),fieldClass);
                //找到了setMethod，一执行就赋值成功了
                System.out.println("请给"+fieldName+"赋值");
                String value = input.nextLine();
                //如何将string类型值转换为属性类型的值
                //每个包装类都有一个含String类型的构造方法。
                //获取每个包装类的带String参数的构造方法
                Constructor con = fieldClass.getConstructor(String.class);
                setMethod.invoke(obj,con.newInstance(value));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return obj;
    }


}
