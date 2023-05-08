package leetcode.pro41;

public class Solution2 {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            // 位置正确
            if(nums[i] == i + 1) {
                continue;
            }
            // 位置不正确 不断交换
            exchange(i, nums[i], nums);
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void exchange(int initLocation, int val, int[] nums) {
        // val 应该存在的位置 location
        int location = val - 1;
        if(location < 0 || location >= nums.length) {
//            数组越界 不换
            return;
        }
        // tmp val 应该存在的位置 上的值
        int tmp = nums[location];
        if(tmp <= 0 || tmp > nums.length) {
            nums[location] = val;
            nums[initLocation] = tmp;
        }
        if(tmp == location + 1) {
            return;
        } else {
            nums[location] = val;
            exchange(initLocation, tmp, nums);
        }
    }
}
