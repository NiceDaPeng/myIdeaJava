package testclassdemo;

import java.lang.reflect.Field;

public class TestClass {


    public static void main(String[] args) throws Exception {

        //获取一个类的Class对象的三种方式
        /*
        * Class.forName("类的全名”);
        * 类名.class;
        * 对象名.getClass();
        *
        * */

        String str = new String("abc");

        System.out.println(str);
        System.out.println(str.hashCode());
        Class clazz = str.getClass();
        Field field = clazz.getDeclaredField("value");
        field.setAccessible(true);
        char[] temp = (char[])field.get(str);
        temp[0] = '娃';
        temp[1] = '哈';
        temp[2] = '哈';
        System.out.println(str);
        System.out.println(str.hashCode());

//        Person person = new Person();Person
//        Class<? extends Person> aClass = person.getClass();
//        Field name = aClass.getDeclaredField("name");
//        Class<?> type = name.getType();
//        Field value = type.getDeclaredField("value");
//        value.setAccessible(true);


//        Class<?> aClass = Class.forName("testclassdemo.Person");
//        Field name = aClass.getDeclaredField("name");
//        name.setAccessible(true);
//        int modifiers = name.getModifiers();
//        System.out.println(modifiers);
//        Person person = new Person();
//        name.set(person,"刁湃锦");
//        String value = (String)name.get(person);
//        System.out.println(person);


//        Class clazz = Person.class;
//        int modifiers = clazz.getModifiers();
//        String name = clazz.getName();
//        String simpleName = clazz.getSimpleName();
//        Class superclass = clazz.getSuperclass();
//        Class[] interfaces = clazz.getInterfaces();
//        String simpleName1 = superclass.getSimpleName();
//        System.out.println(simpleName1);
//        System.out.println(simpleName);
//        System.out.println(name);
//        System.out.println(modifiers);
    }
}
