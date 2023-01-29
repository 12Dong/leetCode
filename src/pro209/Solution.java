package pro209;

public class Solution {

    public int minSubArrayLen(int target, int[] nums) {

        int l = 0, r = 0;
        int cur = 0;
        int ans = Integer.MAX_VALUE;
        while(r < nums.length) {
            cur += nums[r];

            while(cur >= target && l <= r) {

                ans = Math.min(ans, r - l + 1);
                cur -= nums[l];
                l++;
            }

            r++;

        }

        while(cur >= target && l <= r) {
            ans = Math.min(ans, r - l + 1);
            cur -= nums[l];
            l++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] argv) {
        new Solution().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
    }
}
