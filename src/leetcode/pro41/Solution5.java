package leetcode.pro41;

public class Solution5 {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] == i + 1) {
                continue;
            } else {
                change(nums, nums[i], i);
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public void change(int[] nums, int value, int index) {
        int targetIndex = value - 1;
        if(targetIndex >= nums.length || targetIndex < 0) {
            return;
        }
        if(nums[targetIndex] == targetIndex + 1) {
            return;
        }
        int tmp = value;
        nums[index] = nums[targetIndex];
        nums[targetIndex] = tmp;
        change(nums, nums[index], index);
    }

    public static void main(String[] argv) {
        new Solution5().firstMissingPositive(new int[]{3,4,-1,1});
    }

}
