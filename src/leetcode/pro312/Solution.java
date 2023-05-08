package leetcode.pro312;

public class Solution {

    public int maxCoins(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] arrays = new int[nums.length + 2];
        arrays[0] = 1;
        for(int i = 0; i < nums.length; i++) {
            arrays[i + 1] = nums[i];
        }
        arrays[arrays.length - 1] = 1;
        int[][] dp = new int[arrays.length][ arrays.length];
//        for(int i = 0; i < arrays.length; i++) {
//            dp[i][i] = arrays[i];
//        }
        // 枚举区间
        for(int n = 1; n <= arrays.length; n++) {
            // 枚举起点
            for(int i = 0; i < arrays.length - n; i++) {
                caculate(i, i + n, dp, arrays);
            }
        }
        return dp[0][arrays.length -1];
    }

    public void caculate(int l, int r, int[][] dp, int[] arrays) {
        for(int i = l + 1; i < r; i++) {
            dp[l][r] = Math.max(dp[l][r], dp[l][i] + arrays[l] * arrays[i] * arrays[r] + dp[i][r]);
        }

    }

    public static void main(String[] argv) {
        System.out.println(new Solution().maxCoins(new int[]{2,3,7,9,1}));
    }
}
