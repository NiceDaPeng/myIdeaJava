package testsam;

public class Test {

    //用这个方法计算a和b的结果。
    public static void getProduct(int a,int b,IntCal tools){
        int cal = tools.cal(a, b);
        System.out.println("结果是："+cal);
    }

    public static void main(String[] args) {

        getProduct(1,2,((a, b) -> a+b));
    }
}
