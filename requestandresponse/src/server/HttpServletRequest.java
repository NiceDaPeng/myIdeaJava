package server;

import java.util.HashMap;

public class HttpServletRequest {

    private String content;
    private HashMap<String,String> kvMap;

    public HttpServletRequest() {
    }

    public HttpServletRequest(String content, HashMap<String, String> kvMap) {

        this.content = content;
        this.kvMap = kvMap;
    }

    public String getContent() {

        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public HashMap<String, String> getKvMap() {
        return kvMap;
    }

    public void setKvMap(HashMap<String, String> kvMap) {
        this.kvMap = kvMap;
    }
}
