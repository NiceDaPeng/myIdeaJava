package day2203;

import java.util.Comparator;

public class MyArrays {

    public static void sort(Object[] arr, Comparator c){
        for (int i =1; i < arr.length;i++ ){
            for (int j = 0; j < arr.length - i; j++) {
                if (c.compare(arr[j],arr[j+1]) > 0){
                    Object o = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = o;
                }
            }
        }
    }
}
