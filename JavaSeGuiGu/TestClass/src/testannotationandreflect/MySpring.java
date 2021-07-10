package testannotationandreflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MySpring {

    //设计一个方法获取一个类的对象并通过读取注解的信息来完成属性的赋值
    public Object getBean(String className){
        Object obj = null;
        try {
            //根据名字获取到类
            Class clazz = Class.forName(className);
            //获取类的构造方法
            Constructor con = clazz.getConstructor();
            obj = con.newInstance();
            //通过构造方法获取构造方法上的注解信息
            Annotation ann = con.getAnnotation(MyAnnotation.class);
            //通过这个注解信息获取到注解类
            Class aClass = ann.getClass();
            //通过注解类获取到注解中的方法
            Method method = aClass.getMethod("value");
            //让方法执行一遍就得到了注解中方法的返回值。
            String[] values = (String[])method.invoke(ann);
            //获取所有的属性
            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                //通过属性的名字获取其set方法
                String fieldName = fields[i].getName();
                String firstName = fieldName.substring(0, 1).toUpperCase();
                String otherName = fieldName.substring(1);
                StringBuilder setMethod = new StringBuilder("set");
                setMethod.append(firstName);
                setMethod.append(otherName);
                //获取属性的类型，因为我们在调用set方法的时候需要知道方法的名字和参数的类型
                Class fieldType = fields[i].getType();
                Method method1 = clazz.getMethod(setMethod.toString(),fieldType);
                //通过field的类型获取对应类型的含有String类型的构造方法，然后创建对象将values[i]作为参数传进去
                method1.invoke(obj,fieldType.getConstructor(String.class).newInstance(values[i]));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
