import java.util.ArrayList;
import java.util.List;

public class TestMain {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        for (Integer value :
                list) {
            System.out.println(value);
        }

    }
}
