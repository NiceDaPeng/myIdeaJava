package com.dpj.requestapi;

public class Test {
    public static void main(String[] args) {
        int[] arr = {2,2,4,4,6,9};
        int[] arr1 = {2,2,4,4};
        double value = findMedianSortedArrays(arr, arr1);
        System.out.println("----------");
        System.out.println(value);
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double avg = 0;
        int[] result = new int[nums1.length+nums2.length];
        for(int i= 0; i<nums1.length;i++){
            result[i] = nums1[i];
        }
        int num1 = nums1.length;
        for (int i = 0; i < nums2.length; i++) {
            result[num1++] = nums2[i];
        }

        for(int i=0;i<result.length;i++){
            for (int j = 0; j < result.length - i -1; j++) {
                if(result[j] > result[j+1]){
                    int temp = result[j];
                    result[j] = result[j+1];
                    result[j+1] = temp;
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
                             //22224444
        if (result.length % 2 == 0){
            avg = (result[result.length / 2 -1] + result[result.length/2])/2;
        } else {
            avg = result[(int)result.length/2];
        }

        return avg;
    }

    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        char temp = chars[0];
        for (int i = 0; i < chars.length -1; i++) {

            chars[i+1] = chars[numRows+i+1];

        }
        return "";
    }
}
