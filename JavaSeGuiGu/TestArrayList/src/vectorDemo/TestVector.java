package vectorDemo;

import java.util.Stack;
import java.util.Vector;

public class TestVector {

    public static void main(String[] args) {

        Vector<Integer> vec = new Vector();
        vec.add(10);
        vec.add(20);
        vec.add(30);
        System.out.println(vec.size());

        Stack<String> str = new Stack();
        str.push("he");
        str.push("ll");
        str.push("o");
        str.push("world");

        String pop = str.pop();//查看栈顶元素并删除
        System.out.println(pop);
        String peek = str.peek();//查看栈顶元素不删除
        System.out.println(peek);
        System.out.println(str);

        System.out.println(str.size());
        System.out.println(vec.size());


    }
}
