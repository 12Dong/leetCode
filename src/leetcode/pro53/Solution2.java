package leetcode.pro53;

public class Solution2 {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                sum = nums[i];
                ans = Math.max(sum, ans);
            } else {
                if(sum + nums[i] > nums[i]) {
                    sum += nums[i];
                } else {
                    sum = nums[i];
                }
                ans = Math.max(sum, ans);
            }
        }
        return ans;
    }
}
