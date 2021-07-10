package util;

import java.util.HashMap;

public class ThreadLocalManager {

    private static HashMap<String,ThreadLocal> localMap = new HashMap<>();

    //用来管理ThreadLocal对象 每一个对象都可以通过一个name获得。
//    public static ThreadLocal getObj(String name){
//        ThreadLocal local = localMap.get(name);
//        if (local == null){
//            local = new ThreadLocal();
//            //如果集合中没有这个name对应的local对象，那么就创建一个对象。
//            localMap.put(name,local);
//        }
//        return local;
//    }


    public static ThreadLocal getLocal(String name){
        ThreadLocal local = localMap.get(name);
        if (local == null){
            local = new ThreadLocal();
            localMap.put(name,local);
        }
        return local;
    }
}
