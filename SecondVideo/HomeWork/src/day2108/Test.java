package day2108;

import java.util.Arrays;

public class Test {

    //声明一个方法用来反转任意类型的数组
    public <T> void reverseArray(T[] arr){

        for (int i = 0; i < arr.length/2; i++){
            T value = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = value;
        }
    }

    public static void main(String[] args) {

        Integer[] arr = {1,2,3,4,7,3};
        Test t = new Test();
        t.reverseArray(arr);

        for (int value :
                arr) {
            System.out.println(value);
        }
    }
}
