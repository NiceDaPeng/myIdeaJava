package server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HttpServletResponse {

    //这个类是为了存储响应信息的,响应给浏览器的内容都是字符串所以此时我们可以创建一个StringBuilder对象用来存储
    private StringBuilder builder = new StringBuilder();

    //设计一个方法向builder中存储消息
    public void write(String str){
        this.builder.append(str);
    }

    //根据浏览器的资源名找到对应的文件
    public void sendRedirect(String path){

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/file/"+path));
            //读取文件中的一行信息
            String value = reader.readLine();
            while (value != null){
                //没读一行就追加到builder中
                this.builder.append(value);
                value = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //将字符串返回给服务器
    public String getResponseContent(){
        return this.builder.toString();
    }
}
