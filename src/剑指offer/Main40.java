package 剑指offer;

import java.util.PriorityQueue;

/*
* 求数组中最小的k个数
*
* 思路：用partition方法            时间复杂度KO(N)
* 思路：用最大堆                  时间复杂度nlogk 空间复杂度k   适合海量数据
* */
public class Main40 {
    public static int[] getLeastNumbers(int[] arr, int k) {
        /*边界判断*/
        if (arr == null || arr.length <= 0 || arr.length < k)
            return null;
        if (arr.length == k)
            return arr;
        /*方法1:用partition方法*/
        int start = 0;
        int end = arr.length-1;
        int index = 0;
        while( start < end){
            index = partition(arr,start,end);
            if (index == k-1){
                break;
            }else if (k -1 < index){
                end = index -1;
            }else
                start = index + 1;
        }
        int[] res = new int[k];
        for (int i = 0; i < k ; i++) {
            res[i] = arr[i];
        }
        return res;

    }

    private static int partition(int[] arr, int start, int end) {
        int temp = arr[start];
        while(start < end){
            while(start < end && temp <= arr[end])
                end--;
            arr[start] = arr[end];
            while(start < end && temp > arr[start])
                start++;
            arr[end] = arr[start];
        }
        arr[start] = temp;
        return start;
    }

    public static int[] getLeastNumbersTow(int[] arr, int k) {
        /*边界判断*/
        if (arr == null || arr.length <= 0 || arr.length < k)
            return null;
        if (arr.length == k)
            return arr;
        int [] res = new int[k];
        for (int i = 0; i < arr.length; i++) {
            if (i < k-1){
                res[i] = arr[i];
                continue;
            }
            if (i == k-1){
                res[i] = arr[i];
                dump(res);
            } else{
                if (arr[i] < res[0]){
                    res[0] = arr[i];
                    dumpA(res,0, res.length);
                }
            }
        }
        return res;

    }

    private static void dump(int[] res) {
//       构造大根堆
        for (int i = res.length>>1; i >= 0 ; i++) {
            dumpA(res,i,res.length);
        }
    }

    private static void dumpA(int[] res, int parent, int length) {
        int temp = res[parent];
        int child = (parent<<1)+1;
        while(child < length){
            if (child+1 < length && res[child] < res[child+1])
                child++;
            if (temp >= res[child])
                break;
            res[parent] = res[child];
            parent = child;
            child = (parent<<1)+1;
        }
        res[parent] = temp;
    }


    public static void main(String[] args) {
        int [] array = {
                0,0,1,2,4,2,2,3,1,4
        };
        int[] leastNumbers = getLeastNumbers(array, 8);
        System.out.println(leastNumbers);

    }
}
