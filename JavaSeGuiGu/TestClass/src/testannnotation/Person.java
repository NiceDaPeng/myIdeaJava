package testannnotation;

import java.io.Serializable;
@SuppressWarnings("serial")//告诉类实现了序列化接口，但是不添加序列号，你不要警告了，我不需要。
public class Person implements Serializable {


}
