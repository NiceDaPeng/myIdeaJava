package array;

public class BubbleSort {

    //冒泡排序

    public static void main(String[] args) {

        //给定一个数组 ，对数组进行升序排列
        int[] arr = {1,6,9,3,5,2,8};

        //冒泡排序
        //冒泡排序是两个数值两两比较，每次比较的时候较小/较大的值冒出来
        //升序--
        //第一次  arr.length-1 位置的元素 和 arr.length - 2位置的元素进行比较
        //第二次  arr.length -2位置的元素和  arr.length -3位置的元素进行比较
        //以此类推知道 1 位置的元素和 0 位置的元素进行比较

        //第一次比较 arr.length -1次
        //第二次比较arr.length - 2次
        //第三次比较arr.length -3次
        //以此类推

        //外for循环控制比较的轮次
        for (int i = 1; i < arr.length;i++ ){
            //内循环控制元素的比较,从最后一个元素开始 和上一个元素进行比较。
            //因为每一轮最后一个比的，一定是每一轮所冒出来的元素的位置。所以这时候要j>i来作为终止循环的条件
            for (int j = arr.length - 1; j >= i; j--){
                if (arr[j] < arr[j-1]){
                    //将当前元素和上一个元素进行比较，如果小，则交换位置
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int value : arr){
            System.out.println(value);
        }

        System.out.println("======================");
        //降序
        //冒泡排序是对元素进行两两比较，每一次比较往上冒出一个最小值或最大值
        //如果我们想要降序，那么每一次就要冒出一个最大值
        //第一次比较  arr.length - 1 和 arr.length - 2比较
        //第二次比较  arr.length -2 和arr.length -3 比较  以此类推
        //如果用一个for循环只能冒出一个最大值，所以要用到for循环的嵌套。
        //外层for控制的是轮次 每一轮比较出来一个最大值。
        //需要比较的轮次 刚好是arr.length -1次
        for (int i = 1; i < arr.length; i++){
            //外层循环执行以此，内存循环跑一圈，这样内层循环每执行一圈就冒出一个最大值
            //每一次循环冒出一个最大值，所以内层循环的次数也会根据外层循环的i值变化而变化
            //i = 1  冒出一个最大值
            //i = 2  冒出一个最大值，此时0索引的值和1索引的值就不用再去比较了
            //因为每一次你循环都是剩下元素的最大值。

            //从最后一个开始，到i-1结束。
            for (int j = arr.length -1; j >= i; j--){
                //判断，如果最后一个元素大于上一个元素，则交换位置
                if (arr[j] > arr[j -1]){
                    int temp = arr[j];
                    arr[j] = arr[j -1];
                    arr[j - 1] = temp;
                }
            }
        }

        for (int value : arr){
            System.out.println(value);
        }

    }
}
