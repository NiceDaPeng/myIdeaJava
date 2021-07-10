package day2203;

import java.util.Comparator;

public class AgeComparartor implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;
        return s1.getAge() - s2.getAge();
    }
}
