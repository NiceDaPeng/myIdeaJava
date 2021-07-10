package testsession;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

//负责管理session 一个对象就够了
public class SessionManager {

    //用来存储session对象的 一个就够了，但是集合里面的东西有好多个。
    private HashMap<String,HttpSession> map = new HashMap<>();

    //返回一个session对象
    public HttpSession getSession(String key){
        return map.get(key);
    }

}


