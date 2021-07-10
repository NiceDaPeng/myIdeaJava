package day2202;

import java.util.ArrayList;
import java.util.Arrays;

public class TestComparator {

    public static void main(String[] args) {

        Student s1 = new Student("秦兰兰",20,90.8);
        Student s2 = new Student("刁湃锦",23,89.8);
        Student s3 = new Student("张三",25,91.8);

        Student[] stus = new Student[3];
        stus[0] = s1;
        stus[1] = s2;
        stus[2] = s3;
        Arrays.sort(stus,new Student());
        for (int i = 0; i < stus.length; i++) {
            System.out.println(stus[i]);
        }
    }
}
