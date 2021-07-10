package server;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

public class ServletController{

    //首先我们要先将文件中的对应信息加载到缓存中，这样可以加快我们的访问速速
    private static HashMap<String,String> contents = new HashMap<>();
    //每次浏览器的请求，我们只需要读取一次信息到缓存中即可，所以也就没有必要每次读取都创建对象，这时候可以将对象设计为单例模式
    private static HashMap<String,HttpServlet> objMap = new HashMap<>();

    static {
        Properties pro = new Properties();
        try {
            pro.load(ServletController.class.getClassLoader().getResourceAsStream("web.properties"));
            Enumeration<?> keyNames = pro.propertyNames();
            while (keyNames.hasMoreElements()){
                String keyname = (String)keyNames.nextElement();
                String value = pro.getProperty(keyname);
                contents.put(keyname,value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //根据request携带的请求资源名去寻找请求的目的地
    public static void findController(HttpServletRequest request, HttpServletResponse response) {
        //获取资源名
        String content = request.getContent();
        //根据资源名去集合中找是否存在这么一个对象
        HttpServlet controllerObject = objMap.get(content);
        try {
            //如果不存在
            if (controllerObject == null){
                String realObjectName = contents.get(content);
                if (realObjectName != null){
                        Class<?> clazz = Class.forName(realObjectName);
                        controllerObject = (HttpServlet) clazz.newInstance();
                        objMap.put(content,controllerObject);
                }
            }
            //通过反射机制找到控制层来做事情
            Class<? extends HttpServlet> aClass = controllerObject.getClass();
            Method method = aClass.getMethod("service", HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(controllerObject,request,response);

        } catch (ClassNotFoundException e) {
            response.write("请求的内容不存在");
        } catch (NoSuchMethodException e) {
            response.write("405，没有可执行的方法");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
