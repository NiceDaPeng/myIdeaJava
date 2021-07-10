package testclassgetmethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMethod {

    public static void main(String[] args)  {

        //获取Person对应的Class对象。

        //通过clazz获取方法
        //通过方法名字定位方法
        //通过方法参数的类型对应的Class对象来找寻
        try {

            Class<Person> clazz = Person.class;
            Person p = clazz.newInstance();
            //getMethod方法是获取自己类和父类中的公有的方法 返回值为一个Method
            Method m = clazz.getMethod("eat",String.class);
            //获取自己类和父类中所有的公有的方法。返回值是一个Method类型的数组。
            Method[] methods = clazz.getMethods();
            //让方法执行一次。第一个参数是对象，第二个参数是方法中的参数列表
            //返回值是Object类型的，所以需要造型。
            String arg =(String)m.invoke(p, "测试参数");
            System.out.println(arg);

//            int modifier =  m.getModifiers();//获取修饰符
//            Class<?> returnType = m.getReturnType();//获取返回值类型，返回值为当前方法返回值类型的Class对象
//            String name = m.getName();//获取当前方法的名字
//            Class<?>[] parameterTypes = m.getParameterTypes();//获取当前方法的参数类型。返回值为一个Class类型的数组。
//            Class<?>[] exceptionTypes = m.getExceptionTypes();//获取方法抛出异常的类型 返回值为Class类型数组。

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
