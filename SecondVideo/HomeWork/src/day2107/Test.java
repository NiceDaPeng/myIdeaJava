package day2107;

public class Test<T> {

    //利用泛型方法 实现数组内元素的交换
    public T[] changeValue(T[] arr,int a,int b){

        T value = arr[a];
        arr[a] = arr[b];
        arr[b] = value;
        return arr;
    }

    public static void main(String[] args) {
        Integer[]  arr= {1,2,3,4,5};
        Test t = new Test();
        Integer[] newArr =(Integer[]) t.changeValue(arr, 1, 3);
        for (int value :
                newArr) {
            System.out.println(value);
        }
    }
}
