package service;

import java.util.HashMap;

public class MySpring {


    private static HashMap<String,Object> beanbox = new HashMap<String, Object>();

    /**
     * 获取所有类的对象
     * @param className 需要获取对象的类的全名
     * @param <T>  返回值的类型。
     * @return  返回一个类的对象。
     */
    public <T>T getBean(String className){
        T obj =null;

        if (obj == null){
            try {
                obj= (T) beanbox.get(className);
                Class clazz = Class.forName(className);
                obj = (T) clazz.newInstance();
                beanbox.put(className,obj);
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
