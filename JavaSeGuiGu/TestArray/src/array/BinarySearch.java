package array;

public class BinarySearch {

    public static void main(String[] args) {

        //给定一个数组查找元素所在的索引位置
        int[] arr = {1,3,5,7,9,10};
        int value = 10;
        int index = -1;
        int left = 0;
        int right = arr.length -1;
        int mid = (left + right) / 2;

        while(left <= right){
            //如果给定的值与中间的值刚好相等，则将中间值的索引赋值给index，然后挑出循环
            if (value == arr[mid]){
                index = mid;
                break;
                //如果给定的值大于中间的值 那么就将给定值的下一个元素的值赋值给left ，
                // 从left开始查找 ，查找到right结束。
            }else if (value > arr[mid]){
                left = mid+1;
                //否则还是从0查找，查找到中间值的前一个元素结束
            }else {
                right = mid - 1;
            }
            //按照现在的left或right重新计算中间值
            mid = (left + right)/2;
        }

        if (index == -1){
            System.out.println("您查找的元素不存在");
        }else {
            System.out.println(value + "所在的索引位置为："+index);
        }
    }
}
