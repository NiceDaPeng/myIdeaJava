package teststream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("all")
public class Test {
    public static void main(String[] args) {

        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("张三",9000D));
        list.add(new Employee("里斯",9010D));
        list.add(new Employee("王五",7500D));
        list.add(new Employee("赵六",9030D));
        list.add(new Employee("钱七",9004D));
        list.add(new Employee("小明",5000D));
        list.add(new Employee("小明",7000D));
        list.add(new Employee("小明",5050D));
        list.add(new Employee("小明",5900D));

        //去掉重复的并遍历流中的数据
        list.stream().distinct().forEach(System.out::println);
        //去掉重复的，跳过1个选5个流中的数据打印出来。
        list.stream().distinct().skip(1).limit(5).forEach(System.out::println);
        //将员工对象转换为String对象
        list.stream().distinct().map(t -> t.getName() +":"+ t.getSalary()).forEach(System.out::println);
        System.out.println("==========fengexian");
        //将员工对象转换为Double对象
        list.stream().distinct().map(t -> t.getSalary()).forEach(System.out::println);
        //将流中的数据去掉重复的，按照定制排序进行从小到大排序。
        list.stream().distinct().sorted((t1,t2) -> -(int)(t1.getSalary() - t2.getSalary())).forEach(System.out::println);
        System.out.println("===========分割线");
        //找出工资低于8000并倒序排序
        Optional<Employee> first = list.stream().filter(t -> t.getSalary() <= 8000).sorted((t1, t2) -> -(int) (t1.getSalary() - t2.getSalary())).findFirst();
        Employee employee = first.orElse(new Employee());
        System.out.println(employee);

        long count = list.stream().distinct().filter(t -> t.getSalary() < 8000).count();
        System.out.println(count);
//        System.out.println(first.get());
        //求全部工资的总和
        Optional<Double> reduce = list.stream().distinct().map(employee1 -> employee1.getSalary()).reduce((t1, t2) -> t1 + t2);
        Double aDouble = reduce.orElse(-1.0);
        System.out.println(aDouble);

        //手机流中的数据到新的集合
        List<Employee> collect = list.stream().distinct().filter(t -> t.getSalary() > 8000).collect(Collectors.toList());
        System.out.println(collect);

        //获取并行流--并行流就时多线程的
        list.parallelStream().distinct().filter(t -> t.getSalary() > 8000).collect(Collectors.toList());
        boolean b = Stream.of(1, 2, 3, 4, 5).allMatch(t -> t % 2 != 0);
        System.out.println(b);
        String str1 = "hee";
        Optional<String> hello = Optional.of(str1);
        String str = null;
        Optional<String> world = Optional.ofNullable(str);

        String str2 = null;
        Optional<String> str21 = Optional.of(str2);
        String s = str21.orElseGet(String::new);
        System.out.println(s);

        String str3 = null;
        Optional<String> str4 = Optional.of(str3);
        String s1 = str4.orElseThrow(()->new RuntimeException("对象为空"));
        System.out.println(s1);

//        ArrayList<Employee> list = new ArrayList<>();
//        list.add(new Employee("zhangsan",90000D));
//        list.add(new Employee("zhangsan",90000D));
//
//        Stream stream = list.stream();
//        stream = stream.distinct();//默认调用重写的equals方法
//        long count = stream.count();
//        System.out.println(count);
//        System.out.println("over");

//        int[] arr = {1,2,3,4,5};
//        IntStream stream = Arrays.stream(arr);

//        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
//        Stream<String> hello = Stream.of("hello", "world", "java");

//        Stream<Double> stream = Stream.generate(Math::random);
//        stream.forEach(System.out::println);


    }
}
