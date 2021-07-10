package testlambda;

import java.util.HashMap;

public class Test {

    public static void main(String[] args) {

//        new Thread(()->{
//            System.out.println("helloWorld");
//            System.out.println("Java");
//        }).start();
        HashMap<String,Employee> map = new HashMap<>();
        map.put("张三",new Employee("张三",9000D));
        map.put("里斯",new Employee("里斯",9000D));
        map.put("王五",new Employee("王五",10000D));

        map.replaceAll((key,emp)->{
            if (emp.getSalary() < 10000){
                emp.setSalary(10000D);
            }
            return emp;
        });
        map.forEach((s, employee) -> System.out.println(employee.getName() +"-"+employee.getSalary()));
    }
}
