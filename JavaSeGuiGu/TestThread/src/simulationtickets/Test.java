package simulationtickets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Test {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(209);
//        Object clone = list.clone();
        list.remove(0);

        System.out.println(list);
        System.out.println(list.isEmpty());
        System.out.println(list.get(0));
        System.out.println(list.size());
        list.clear();
        System.out.println(list);


        HashSet<String> set = new HashSet<String>();
        set.add("hello");
        set.add("world");

        System.out.println(set);

        LinkedList<String> list1 = new LinkedList<String>();
        list1.add("java");
        list1.add("nice");
        System.out.println(list1);

        set.addAll(list1);

        set.remove(0);
        System.out.println( set.contains("java"));
        System.out.println(set);

        Window w1 = new Window("窗口1");
        Window w2 = new Window("窗口2");

        w1.start();
        w2.start();
    }
}
