package util;

import java.util.HashMap;

public class MyThreadLocal {

    private static HashMap<String,ThreadLocal> localMap = new HashMap<>();

    public static ThreadLocal getLocal(String name){
        ThreadLocal local = localMap.get(name);
        if (local == null){
            local = new ThreadLocal();
            localMap.put(name,local);
        }
        return local;
    }
}
