package leetcode.pro41;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == i+1) {
                continue;
            }
            int cur = i;
            int curVal = nums[i];
            while(nums[cur] > 0 && nums[cur] <=nums.length && nums[nums[cur] -1] != nums[cur] ) {
                int tmp = nums[nums[cur] - 1];
                nums[nums[cur] - 1] = nums[cur];
                nums[cur] = tmp;
            }

        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1) {
                return i+1;
            }
        }
        return nums.length + 1;
    }
}
