package leetcode.pro152;

public class Solution {

    public int maxProduct(int[] nums) {
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                dpMax[i] = nums[i];
                dpMin[i] = nums[i];
            } else {
                dpMax[i] = Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]);
                dpMax[i] = Math.max(dpMax[i], nums[i]);

                dpMin[i] = Math.min(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]);
                dpMin[i] = Math.min(dpMin[i], nums[i]);
            }
            ans = Math.max(ans, dpMax[i]);
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution().maxProduct(new int[]{-2,3,-4});
    }
}
