package leetcode.pro209;

public class Solution2 {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int l = 0;
        int r = 0;
        while(r < nums.length) {
            sum += nums[r];
            r++;
            // 满足条件 缩小左节点
            if(sum >= target) {
                while(l < r && sum >= target) {
                    sum -= nums[l];
                    l++;

                }
                ans = Math.min(ans, r - l + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
