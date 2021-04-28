package prom152;

public class Solution {

    public int maxProduct(int[] nums) {
        int length = nums.length;
        // 以 x 为结尾的 乘积最大 连续子数组
        int[] dpMax = new int[length];
        int[] dpMin = new int[length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int result = dpMax[0];
        for(int i = 1; i < length; i++) {
            if(nums[i]>0) {
                dpMax[i] = Math.max(dpMax[i-1] * nums[i], nums[i]);
                dpMin[i] = Math.min(dpMin[i-1] * nums[i], nums[i]);
            } else if(nums[i]<0){
                dpMax[i] = Math.max(dpMin[i-1] * nums[i], nums[i]);
                dpMin[i] = Math.min(dpMax[i-1] * nums[i], nums[i]);
            } else {

            }
            result = Math.max(result, dpMax[i]);
        }

        return result;
    }

    public static void main(String[] argv){
        System.out.println(new Solution().maxProduct(arrays));
    }

    static int[] arrays = new int[]{2,3,-2,4};
//    static int[] arrays = new int[]{-2, 0, -1};
//    static int[] arrays = new int[]{-2, 3, -4};
}
