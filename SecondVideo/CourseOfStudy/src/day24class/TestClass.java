package day24class;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Scanner;

public class TestClass {

    public static void main(String[] args) {
        Student stu = (Student)getBean("day24class.Student");
        System.out.println(stu.getName()+"-"+stu.getAge()+"-"+stu.getSex());

    }
    @MyAnnotation("haha")
    public static Object getBean(String className){
        Scanner input = new Scanner(System.in);
        Object obj = null;
        try {
            Class<?> clazz = Class.forName(className);
            obj = clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for (Field f :
                    fields) {

                String fileName = f.getName();
                if (fileName != "serialVersionUID") {
                    Class<?> fileType = f.getType();
                    String firstName = fileName.substring(0, 1);
                    String s = firstName.toUpperCase();
                    String endName = fileName.substring(1);
                    String methodName = "set" + s + endName;
                    System.out.println("请为" + fileName + "赋值");
                    String value = input.nextLine();
                    Method method = clazz.getMethod(methodName, fileType);
                    Constructor<?> con = fileType.getConstructor(String.class);
                    Object o = con.newInstance(value);
                     method.invoke(obj, o);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static Object getAnnotation(String className){
        Scanner input = new Scanner(System.in);
        Object obj = null;
        try {
            Class<?> clazz = Class.forName(className);
            obj = clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for (Field f :
                    fields) {

                String fileName = f.getName();
                if (fileName != "serialVersionUID") {
                    Class<?> fileType = f.getType();
                    String firstName = fileName.substring(0, 1);
                    String s = firstName.toUpperCase();
                    String endName = fileName.substring(1);
                    String methodName = "set" + s + endName;
                    System.out.println("请为" + fileName + "赋值");
                    String value = input.nextLine();
                    Method method = clazz.getMethod(methodName, fileType);
                    Constructor<?> con = fileType.getConstructor(String.class);
                    Object o = con.newInstance(value);
                    method.invoke(obj, o);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
