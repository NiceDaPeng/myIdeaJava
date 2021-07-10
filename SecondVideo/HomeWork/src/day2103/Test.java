package day2103;

import java.util.Comparator;
import java.util.TreeSet;

public class Test {

    public static void main(String[] args) {

        TreeSet<Student> set = new TreeSet<>();
        set.add(new Student("liusan", 20, 90.0));
        set.add(new Student("lisi", 22, 90.0));
        set.add(new Student("wangwu", 20, 99.0));
        set.add(new Student("sunliu", 22, 100.0));

        for (Student stu1 :
                set) {
            System.out.println(stu1);
        }

        TreeSet<Student> stu = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {

                System.out.println(o1.getName().compareTo(o2.getName()));
                return o1.getName().compareTo(o2.getName());
            }
        });
        stu.addAll(set);

        for (Student values :
                stu) {
            System.out.println(values);
        }
    }
}
