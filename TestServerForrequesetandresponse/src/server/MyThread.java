package server;

import controller.IndexController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashMap;

public class MyThread extends Thread {
    private Socket socket;

    public MyThread(Socket socket){
        this.socket = socket;
    }

    public void run(){
        this.receiveRequest();
    }
    //读取消息
    private void receiveRequest(){

        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String content = reader.readLine();
            this.parseContentAndParams(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //解析
    private void parseContentAndParams(String contentAndParams){
        HashMap<String,String> map = null;
        String content = null;
        int wenhaoIndex = contentAndParams.indexOf("?");
        //如果携带了参数则wenhaoindex为大于等于0，如果等于-1则表示没有查找到问号，则说明没有参数携带
        //携带了参数再去处理参数
        if (wenhaoIndex != -1){
            map = new HashMap<String,String>();
            content = contentAndParams.substring(0,wenhaoIndex);
            String allParams = contentAndParams.substring(wenhaoIndex+1);
            String[] params = allParams.split("&");
            for (String param :
                    params) {
                String[] kv = param.split("=");
                map.put(kv[0],kv[1]);
            }
            //没有携带参数，那么contentparams就是我们要的资源名。
        } else {
            //如果没有携带参数，content就是你要请求的资源名
            content = contentAndParams;
        }

        this.findController(content,map);
    }
    //找人做事,这个人应该是叫控制层  （controller，action，servlet）
    private void findController(String content,HashMap<String,String> paramas){
        if ("index".equals(content)){
            IndexController ic = new IndexController();
            ic.test();
        }
    }

    //响应回去--将最终的响应信息写会浏览器
    private void responseToBrowser(){

    }
}
