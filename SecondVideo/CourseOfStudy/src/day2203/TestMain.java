package day2203;

import java.util.Comparator;

public class TestMain {

    public static void main(String[] args) {
        Student[] stus = new Student[3];
        Student s1 = new Student("里斯",20,90.8);
        Student s2 = new Student("王五",23,89.8);
        Student s3 = new Student("张三",25,91.8);
        AgeComparartor ma = new AgeComparartor();
        stus[0] = s1;
        stus[1] = s2;
        stus[2] = s3;
        MyArrays.sort(stus, ma);

        for (int i = 0; i < stus.length; i++) {
            System.out.println(stus[i]);
        }
    }
}
