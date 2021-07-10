package que20210407;

public class TestReverseNumber {

    public int reverseNumber(int num){
        int b = 0;
        while(num != 0){
            int a = num % 10;
            b = b * 10 +a;
            num = num/10;
        }
        return b;
    }

    public static void main(String[] args) {
        TestReverseNumber tr = new TestReverseNumber();
        int i = tr.reverseNumber(1024);
        System.out.println(i);
    }
}
