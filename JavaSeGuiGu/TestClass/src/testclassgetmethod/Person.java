package testclassgetmethod;

public class Person {

    private String name;

    public void eat(){
        System.out.println("我是person的吃饭方法");
    }

    public String eat(String str){
        System.out.println("我是带参数的eat方法");
        return str;
    }

    public Person(){

    }

    private Person(String name){
        this.name= name;
    }

}
