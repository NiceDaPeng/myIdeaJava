package factorydesignmode;

public class Factory {

    public static Object getInstance(String className){
        Class<?> aClass = null;
        Object o = null;
        try {
            aClass = Class.forName(className);
            o = aClass.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return o;
    }
}
