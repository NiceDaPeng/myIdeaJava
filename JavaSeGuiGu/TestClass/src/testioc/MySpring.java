package testioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class MySpring {

    //通过字符串获取类的对象，同时为属性赋值
    public Object getBean(String className){
        Scanner input = new Scanner(System.in);
        System.out.println("请为对象属性赋值");
        Object obj = null;

        try {
            //获取字符串的类的对象
            Class<?> clazz = Class.forName(className);
            obj = clazz.newInstance();

            //通过对象来获取所有的属性名字
            Field[] fields = clazz.getDeclaredFields();
            for (Field field :
                    fields) {
                //获取属性的名字
                String fieldName = field.getName();
                //获取属性的数据类型
                Class<?> fileClassName = field.getType();
                //将属性的名字进行截取，并将属性名字的第一个字母大写
                // 因为我们的get和set方法都是按照属性名子的第一个字母大写来设置的
                String firstString = fieldName.substring(0, 1);
                String secString = fieldName.substring(1);
                //创建一个StringBuilder对象设置set方法的名字
                StringBuilder setMethodName = new StringBuilder("set");
                setMethodName.append(firstString.toUpperCase());
                setMethodName.append(secString);
                //根据方法的名字和参数的类型，获得Method对象
                Method setMethod = clazz.getMethod(setMethodName.toString(), fileClassName);
                System.out.println("请为"+fieldName+"赋值");
                String value = input.nextLine();
                Constructor con = fileClassName.getConstructor(String.class);
                //方法的Method对象调用invoke（）方法来让方法运行一次，就为属性赋值了。
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
