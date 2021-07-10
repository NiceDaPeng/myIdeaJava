package reflect;

import java.lang.reflect.Field;

public class Test {

    public static void main(String[] args) {

        Class<?> clazz = null;
        try {
            clazz = Class.forName("reflect.Student");
            Field fieldName = clazz.getDeclaredField("name");
            fieldName.setAccessible(true);

        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(clazz);
    }
}
