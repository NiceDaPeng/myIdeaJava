package exceptiontest;

public class TestMain {

    //设计一个方法用来获取输入的值的

    public void range(int value) throws RuntimeException{
        value = value / 0;
    }

    public static void main(String[] args) {

        TestMain tm = new TestMain();
        try {
            tm.range(0);
        }catch (Exception e){
            System.out.println("你除零了");
        }
    }
}
