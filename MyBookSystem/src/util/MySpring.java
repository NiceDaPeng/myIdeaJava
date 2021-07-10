package util;

import java.util.HashMap;

public class MySpring {

    private static HashMap<String,Object> beanBox = new HashMap<>();


    public static Object getBean(String className){
        Object obj = beanBox.get(className);
        if (obj == null){
            try {
                Class clazz = Class.forName(className);
                obj = clazz.newInstance();
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
