package util;

import java.util.HashMap;

public class MySpring {

    private static HashMap<String,Object> beanBox = new HashMap<>();
    public static <T>T getBean(String className){
        T obj = (T) beanBox.get(className);
        if (obj == null){
            try {
                obj = (T) Class.forName(className).newInstance();
                beanBox.put(className,obj);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
        return obj;
    }
}
