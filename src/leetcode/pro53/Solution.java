package leetcode.pro53;

public class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int last = 0;
        for(int i =0; i < nums.length; i++) {
            if(i == 0) {
                last = nums[0];
            } else {
                last = Math.max(last + nums[i], nums[i]);
            }
            ans = Math.max(ans, last);
        }
        return ans;
    }
}
