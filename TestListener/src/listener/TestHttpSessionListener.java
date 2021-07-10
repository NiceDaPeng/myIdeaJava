package listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class TestHttpSessionListener implements HttpSessionListener,HttpSessionAttributeListener {

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session对象被销毁了");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session对象被创建了");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("session域对象里面添加值了");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("session域对象里面的值被删除了");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        System.out.println("session域对象里面的值被修改了");
    }
}
