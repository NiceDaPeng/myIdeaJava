package homework;

public class Student {

    private String name;
    private String password;
    private int score;

    public Student(){

    }

    public Student(String name,String password){

    }

    public Student(String name){
        this.name = name;
    }

    public void setScore(int score){
        this.score = score;
    }

    public String getName(){
        return this.name;
    }


    public int getScore(){
        return this.score;
    }

    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }

        if (obj instanceof Student){
            Student student = (Student)obj;
            if (this.name.equals(student.name)){
                return true;
            }
        }

        return false;
    }

    public int hashCode(){

        return this.name.hashCode();
    }

    public String toString(){

        StringBuilder builder = new StringBuilder("{");
        builder.append(this.name);
        builder.append(",");
        return builder.toString();
    }
}
