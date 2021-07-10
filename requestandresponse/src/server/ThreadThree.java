package server;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;

public class ThreadThree extends Thread {
    private Socket server;

    public ThreadThree(Socket server) {
        this.server = server;
    }

    @Override
    public void run() {
        this.readRequest();
    }

    //设计一个方法通过流技术用来读取发送来的消息
    public void readRequest() {

        try {
            InputStream inputStream = server.getInputStream();
            //因为浏览器发送来的是一行信息，所以我们可以通过缓冲流的readLine（）方法来直接读取一行
            //需要将字节流转为字符流，因为字节流是没有读取一行的方法的。
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String contentAndParams = reader.readLine();
            paraseContentAndParams(contentAndParams);
            //读取到的内容去解析
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //设计一个方法用来解析浏览器请求的资源和请求参数
    public void paraseContentAndParams(String contentAndparams) {
        //首先要考虑获取什么，获取了以后用什么存起来。针对请求的参数这里要做的就是可以通过map集合存起来，因为里面全是key=value形式的
        int wenhaoIndex = contentAndparams.indexOf("?");
        //创建一个集合对象用来存储参数的keyvalue形式
        HashMap<String, String> kvmap = null;
        String content = null;
        //首先判断是否携带了参数
        if (wenhaoIndex != -1) {
            //首先获取请求的资源名
            content = contentAndparams.substring(0, wenhaoIndex);
            //其次获取请求携带的参数
            String keyValues = contentAndparams.substring(wenhaoIndex + 1);
            //根据&符号将参数进行拆分
            String[] params = keyValues.split("&");
            //创建一个map集合对象
            kvmap = new HashMap<String, String>();
            //将数组中的内容再按照=号进行拆分
            for (String param :
                    params) {
                String[] kv = param.split("=");
                //将请求携带的参数进行拆分成单独的key=value形式存入到map集合中
                kvmap.put(kv[0], kv[1]);
            }
        } else {
            //如果没有携带参数那么只有请求的内容，直接将请求信息赋值给请求内容即可。
            content = contentAndparams;
        }

        //因为浏览器发送来的请求信息有两个部分组成，这里我们可以设计一个类，用来存储这两个信息
        HttpServletRequest request = new HttpServletRequest(content, kvmap);
        HttpServletResponse response = new HttpServletResponse();
        //此时应该将请求信息发送到控制层，让其帮我们去寻找资源。
        ServletController.findController(request, response);
        this.sendResponse(response);

    }


    //将最终的响应信息回传给浏览器
    public void sendResponse(HttpServletResponse response) {
        String responseContent = response.getResponseContent();
        try {
            PrintWriter out = new PrintWriter(server.getOutputStream());
            out.println(responseContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
