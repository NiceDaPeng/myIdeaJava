package util;

import java.util.HashMap;

public class MySpring {
    //创建一个集合用来存储所有被管理的对象
    private static HashMap<String,Object> beanBox = new HashMap<>();

    //设计一个方法 获取任何一个类的对象
    //  返回值(泛型)   参数String 类名
    public static <T>T getBean(String className){
        T obj = null;
        //1.直接取beanBox里面获取
        obj = (T)beanBox.get(className);
        try {
            if (obj == null){
                Class clazz = Class.forName(className);
                obj = (T) clazz.newInstance();
                beanBox.put(className,obj);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
