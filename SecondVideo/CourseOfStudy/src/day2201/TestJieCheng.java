package day2201;

public class TestJieCheng {

    public long jieCheng(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * jieCheng(n - 1);
        }
    }

    public static void main(String[] args) {

        TestJieCheng t = new TestJieCheng();
//        long value = t.jieCheng(5);
        long sum = t.sum(5);
        System.out.println(sum);
//        System.out.println(value);
    }

    //你个台阶一次只能走一步或者两步 又几种走法？
    public long sum(int n) {
        if (n == 1 || n == 2) {
            return n;
        } else {
            return sum(n - 1) + sum(n - 2);
        }
    }
}
