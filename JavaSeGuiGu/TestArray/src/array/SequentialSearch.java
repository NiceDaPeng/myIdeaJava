package array;

public class SequentialSearch {

    //顺序查找，给定一个元素，查找其所在的索引

    public static void main(String[] args) {

        int[] arr = {1,5,2,6,3,8};
        int value = 2;
        int index = 0;

        for (int i = 0; i < arr.length; i++){
            if (arr[i] == value){
                index = i;
                break;
            }
        }
        System.out.println(value+"所在的索引为："+index);
    }
}
