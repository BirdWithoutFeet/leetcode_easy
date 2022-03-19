package 剑指offer;
/*
* 数组中出现次数超过一半的数字
* 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
  输出: 2
* */
public class Main39 {
    public int majorityElement(int[] nums) {
        int index = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0){
                index = nums[i];
                count = 1;
            }else {
                if (index == nums[i])
                    count++;
                else
                    count--;
            }
        }
        return index;
    }
}
