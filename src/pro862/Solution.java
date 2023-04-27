package pro862;

public class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        int sum =  0;
        while(r < nums.length && r >= l) {
            sum += nums[r];
            r++;
            if(sum >= k) {
                ans = Math.min(ans, r - l);
                while(sum >= k && l < r) {
                    sum -= nums[l];
                    l++;
                    if(sum >= k) {
                        ans = Math.min(ans, r - l +1);
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().shortestSubarray(new int[]{1, 2}, 3));
    }
}
