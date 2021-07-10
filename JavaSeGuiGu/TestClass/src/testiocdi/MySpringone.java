package testiocdi;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class MySpringone {

    //Spring里面的核心思想是IOC 和AOP
    /*
    * IOC是控制反转 就是将一个类的对象控制权交给别人来控制
    * DI 是IOC的一部分，就是在创建对象的时候同时为对象的属性赋值。
    * */

    //设计一个方法，根据给定的字符串返回字符串类的对象 ，并实现为对象属性赋值的操作

    public Object getBean(String className){
        Scanner input = new Scanner(System.in);
        System.out.println("请为对象的属性赋值");
        Object obj = null;
        try {
            //通过Class.forName来获取className的类Class对象
            Class<?> clazz = Class.forName(className);
            //获取这个类的对象
            obj = clazz.newInstance();

            //为对象的属性赋值
            //首先我们要先获取所有属性的名字 和类型
            // 因为我们在对其进行赋值操作的时候需要通过set+属性的名字来完成
            // 还需要传递属性所属的类型的Class对象作为参数，
            Field[] fields = clazz.getDeclaredFields();
            //遍历出每一个属性
            for (Field field :
                    fields) {
                //获取属性的名字
                String fieldName = field.getName();
                //获取属性的类型对应的Class对象
                Class fileClassType = field.getType();
                //将fieldName进行截取
                String firstName = fieldName.substring(0, 1).toUpperCase();
                String secName = fieldName.substring(1);
                //创建一个StringBuilder对象将set和截取后的方法名字组合到一起，这样就可以获得方法的名字
                StringBuilder setMethodName = new StringBuilder("set");
                setMethodName.append(firstName);
                setMethodName.append(secName);
                //通过methodName获取Method对象。
                Method setMethod = clazz.getMethod(setMethodName.toString(),fileClassType);
                //获取键盘输入来向set方法里面传值
                System.out.println("请为"+fieldName+"赋值");
                String value = input.nextLine();
                //因为我们方法中的参数不一定都是String类型的，所以我们需要将类型构造为String类型
                //每一个包装类都有以一个构造方法是包含String类型的。
                Constructor con = fileClassType.getConstructor(String.class);
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
