package setdemo;

public class Person {

    private String name;

    public Person(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    //重写equals（）方法
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj instanceof Person){
            Person person = (Person)obj;
            if (this.name.equals(person.name)){
                return true;
            }
        }

        return false;
    }

    //重写hashCode方法

    public int hashCode(){
        return this.name.hashCode();
    }

    //重写toString方法
    public String toString(){
        StringBuilder builder = new StringBuilder("{");
        builder.append(this.name);
        builder.append("}");

        return builder.toString();
    }

}
