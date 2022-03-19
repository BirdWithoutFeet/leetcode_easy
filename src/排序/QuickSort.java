package 排序;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
* 快排*/
public class QuickSort {
    public static void sort(int [] array){
//        平均时间复杂度是nlogn     最坏时间复杂度nn
        if (array == null || array.length <= 0)
            return;
        sortCore(array,0,array.length-1);
    }

    private static void sortCore(int[] array, int start, int end) {
//        平均时间复杂度logn   最坏情况下n
        if (start < end){
            int index = partition(array,start,end);
            sortCore(array,start,index-1);
            sortCore(array,index+1,end);
        }
    }

    private static int partition(int[] array, int start, int end) {
//       时间复杂度 O(n)
        int temp = array[start];
        while(start < end){
            while(start < end && array[end] >= temp)
                end--;
            array[start] = array[end];
            while(start < end && array[start] <= temp)
                start++;
            array[end] = array[start];
        }
        array[start] = temp;
        return start;
    }

    public static void main(String[] args) {
        int [] array = {
                10,90,20,1,-2,20
        };
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
