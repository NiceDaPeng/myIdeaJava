package testclassgetmethod;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestMethod1 {

    public static void main(String[] args) {

        try {
            Class<?> string = Class.forName("testclassgetmethod.Person");
            Method eat = string.getMethod("eat", String.class);
            Constructor<?> constructor = string.getConstructor();
            String name1 = constructor.getName();
            int modifiers1 = constructor.getModifiers();
            System.out.println(name1);
            System.out.println(modifiers1);
            String name = eat.getName();
            int modifiers = eat.getModifiers();
            Class<?> returnType = eat.getReturnType();
            int parameterCount = eat.getParameterCount();
            Class<?>[] parameterTypes = eat.getParameterTypes();
            int length = parameterTypes.length;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
//        try {
//
//
//
////            System.out.println(parameterCount);
////            String simpleName = returnType.getSimpleName();
////            System.out.println(simpleName);
////            System.out.println(modifiers);
////            System.out.println(name);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
    }
}
