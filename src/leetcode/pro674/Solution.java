package leetcode.pro674;

public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int ans = 1;
        int length = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                length++;
                ans = Math.max(ans, length);
            } else {
                length = 1;
            }
        }
        return ans;
    }
}
