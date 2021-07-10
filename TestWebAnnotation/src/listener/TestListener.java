package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class TestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request对象销毁了");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {

        System.out.println("request对象创建了");
    }
}
