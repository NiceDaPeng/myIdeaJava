package myselfannotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMain {

    public static void main(String[] args) {

        try {
            //获取Person类中方法上面的注解信息
            Class<Person> clazz = Person.class;
            Method eat = clazz.getMethod("eat");
            MyAnnotation a = (MyAnnotation) eat.getAnnotation(MyAnnotation.class);
            Class<? extends MyAnnotation> alcazz = a.getClass();
            Method method = alcazz.getMethod("value");
            String[] str = (String[])method.invoke(a);
            for (String value :
                    str) {
                System.out.println(value);
            }


//            //解析Person类中属性上面的注解信息。需要用到反射技术
//            //获取Person对应的类。
//            Class<Person> clazz = Person.class;
//            //通过clazz获取里面的属性
//            Field field = clazz.getDeclaredField("name");
//            //通过属性获取其对应的注解，括号里面的参数是一个Class类型的
//            //获取的是哪个注解类型的注解，因为我们在真正使用中有可能不只是一个注解。
//            MyAnnotation ann = (MyAnnotation) field.getAnnotation(MyAnnotation.class);
//            //利用反射执行MyAnnotation中的方法
//            //注解对应的Class对象
//            Class aClass = ann.getClass();
//            //通过aclass获取里面的value方法（）；
//            Method amethod = aClass.getMethod("value");
//            //执行value方法获取传递的信息,需要知道让方法执行的对象，和方法中的参数。
//            String[] values =(String[]) amethod.invoke(ann);
//            for (String value :
//                    values) {
//                System.out.println(value);
//            }

        }  catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
