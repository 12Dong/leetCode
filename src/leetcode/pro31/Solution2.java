package leetcode.pro31;

import java.util.Arrays;

public class Solution2 {
    public void nextPermutation(int[] nums) {
        // 从右往左 第一个非升序
        int index = -1;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(i != 0) {
                if(nums[i - 1] < nums[i]) {
                    index = i - 1;
                    break;
                }
            }
        }
        if(index == - 1) {
            Arrays.sort(nums);
            return;
        }

        int targetIndex = -1;
        int target = Integer.MAX_VALUE;
        for(int i = index + 1; i < nums.length; i++) {
            if(nums[i] > nums[index]) {
                if(nums[i] < target) {
                    target = nums[i];
                    targetIndex = i;
                }
            }
        }

        // 交换位置 & 排序
        nums[targetIndex] = nums[index];
        nums[index] = target;
        Arrays.sort(nums, index + 1, nums.length);


    }

    public static void main(String[] argv) {
        new Solution2().nextPermutation(new int[]{1,2,3});
    }
}
