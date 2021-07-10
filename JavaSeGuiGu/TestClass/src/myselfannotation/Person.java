package myselfannotation;

public class Person {

    @MyAnnotation({"刁湃锦","19","男"})
    private String name;

    private Integer age;

    private String sex;

    @MyAnnotation({"秦兰兰","18","女"})
    public void eat(){

    }


    //利用反射技术实现了一个IOC，对象有别人来创建，创建同时注入信息
    //原来的设计是自动注入信息又Scanner对象输入进来的。
}
