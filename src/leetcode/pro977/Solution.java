package leetcode.pro977;

public class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] numss = new int[nums.length];
        int start = nums.length;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= 0) {
                start = i;
                break;
            }
        }
        int index = 0;
        int l = start - 1;
        int r = start;
        int[] ans = new int[nums.length];
        while(l >= 0 && r < nums.length) {
            if(Math.abs(nums[l]) < Math.abs(nums[r])) {
                ans[index] = nums[l] * nums[l];
                l--;
            } else {
                ans[index] = nums[r] * nums[r];
                r++;
            }
            index++;
        }
        while(l >= 0) {
            ans[index] = nums[l] * nums[l];
            l--;
            index++;
        }
        while(r < nums.length) {
            ans[index] = nums[r] * nums[r];
            r++;
            index++;
        }
        return ans;
    }
}
