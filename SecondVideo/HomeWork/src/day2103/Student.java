package day2103;

public class Student implements Comparable<Student>{

    private Integer age;
    private String name;
    private Double score;

    public Student() {
    }

    public Student(String name,Integer age,  Double score) {
        this.age = age;
        this.name = name;
        this.score = score;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        if (this.score > o.score){
            return -1;
        } else if (this.score < o.score){
            return 1;
        }
        return this.getAge() - o.getAge();
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
