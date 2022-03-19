package 剑指offer;
/*
* 数组中的逆序对
*输入: [7,5,6,4]
 输出: 5
 *
 *
 * 解法1：轮询   nn
 * 解法2：归并排序解法 时间复杂度nlogn 空间n
 *
 *
* */
public class Main51 {
    int count = 0;
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 1)
            return count;
        this.count = 0;
        int [] temp = new int[nums.length];
        sort(nums,temp,0,nums.length-1);
        return count;
    }

    private void sort(int[] nums, int[] temp, int start, int end) {
        if (start < end){
            int mid = start+(end-start)>>1;
            sort(nums,temp,start,mid);
            sort(nums,temp,mid+1,end);
            merge(nums,temp,start,mid,end);
        }
    }
    private void merge(int[] nums, int[] temp, int start, int mid, int end) {
        int i = start;
        int j = mid+1;
        int t = 0;
        while(i <= mid && j <= end){
            if (nums[i] <= nums[j])
                temp[t++] = nums[i++];
            else {
//                当我们右边的数组指针小于左边数组指针值时，由于左边数组有序，所以我们可以直接获得可以组成的逆序对mid - i +1
                count+=mid-i+1;
                temp[t++] = nums[j++];
            }
        }

        while(i <= mid){
            temp[t++] = nums[i++];
        }
        while(j <= end){
            temp[t++] = nums[j++];
        }
        t = 0;
        while(start <= end){
            nums[start++] = temp[t++];
        }
    }





}
