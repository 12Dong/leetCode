package leetcode.pro41;

public class Solution4 {
    public int firstMissingPositive(int[] nums) {
        // 让每个数字出现在他 i - 1 的位置
        // 重复数字 不动
        // 最后检查第一个不是 i + 1 的位置
        for(int i = 0; i < nums.length; i++) {
            if(i <= 0) {
                continue;
            } else if(nums[i] == i + 1) {
                continue;
            } else {
                exchange(nums, i);
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    // index 当前位置 nextIndex 下一个交互位置()也是 nums[index]的值）
    public void exchange(int[] nums, int index) {
        int value = nums[index];
        if(value <= 0) {
            return;
        }
        int nextIndex = value - 1;
        if(nextIndex < 0 || nextIndex >= nums.length) {
            return;
            // 越界了
        }
        //
        if(nums[nextIndex] == nextIndex + 1) {
            // 重复了
            return;
        } else {
            // 交互 nums[index] 和 nums[nextIndex]的值
            nums[index] = nums[nextIndex];
            nums[nextIndex] = value;
            exchange(nums, index);
        }
    }


}
