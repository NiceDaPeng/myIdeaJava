package array;

public class TestBinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,3,4,6,7};
        int indexOfCenter = getIndexOfCenter(arr, 6);
        System.out.println(indexOfCenter);

    }

    //实现二分查找
    //二分查找是针对有序的数组进行的。先判断中间的值是否与给定的值相等。如果相等就返回中间值的索引/
    //如果给定的值大于中间的值，那么将给定值的索引赋值给左边 如果给定的值小于中间那的值，那么将给定得值赋值给右边。
    public static int getIndexOfCenter(int[] arr,int value){
        int left = 0;
        int right = arr.length - 1;
        int mid = (left+right)/2;
        int index = -1;

        while (left<= right){
            if (value == arr[mid]){
                index = mid;
                break;
            } else if (value < arr[mid]){
                right = mid-1;
            } else {
                left = mid+1;
            }
            mid = (left+right)/2;
        }

        return index;
    }
}
