package array;

public class Directselectionsort {

    public static void main(String[] args) {

        //直接选择排序
        //直接选择排序的方式是 找出未排序元素中的最小值和索引位置
        //如果最小值的索引不在应该在的索引位置，那么就交换其元素
        int[] arr = {1,6,3,8,5,9,2};
        //内层循环控制的是选出未排序的最小值
        //外层循环控制的是需要做几次内层循环。
        //如果这个最小值 没有在应该在的位置，那么把最小值放在应该在的索引位置，

        for (int i = 0; i < arr.length - 1; i++){
            //将第一个元素存入到最小值中
            int min = arr[i];
            //用来存储最小值本来本来位置的索引
            int index = i;
            //用当前元素和其下一个元素进行比较，如果下一个元素的值小于当前元素
            //那么将小的元素赋值给min ，然后记录下这个下标，执行一圈以后，就会找到最小的那个元素
            for (int j = i+1; j < arr.length ;j++){
                if (min > arr[j]){
                    min = arr[j];
                    index = j;
                }
            }
            //判断最小的那个元素所在的位置是否是应该在的位置
            //  如果 最小元素所在的位置是  4，当前循环从0 开始那么 最小值应该在0 位置 所以交换 两个元素
            if (index != i){
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }

            //每一次循环结束都会找到一个最小值，并且放到应该在的位置。
        }

        for (int value : arr){
            System.out.println(value);
        }
    }
}
