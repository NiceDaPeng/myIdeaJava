package springtimer;

import java.util.ArrayList;

//可以理解为这就是一个Task
public class SpringTask {

    public void doSomthing(){
        ArrayList<String> userList = new ArrayList<>();
        userList.add("A同学");
        userList.add("B同学");
        userList.add("C同学");

        for (String str :
                userList) {
            System.out.println("hello"+str+"开启骚扰模式");
        }
    }
}
