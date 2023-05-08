package leetcode.prom53;

import java.util.Arrays;

public class Solution {
//    public int maxSubArray(int[] nums) {
//        int length = nums.length;
//        int[] prefix = new int[length];
//        int result = Integer.MIN_VALUE;
//        for(int i = 0; i < length; i++){
//            if(i == 0) {
//                prefix[i] = nums[0];
//                result = Math.max(result, prefix[i]);
//                continue;
//            }
//            prefix[i] = prefix[i - 1] + nums[i];
//            result = Math.max(result, prefix[i]);
//
//        }
//        for(int i = 0; i < length; i++){
//            for(int j = 0; j < i; j++){
//                result = Math.max(prefix[i] - prefix[j], result);
//            }
//        }
//        return result;
//    }

    public static void main(String[] argv){
//        System.out.println(new Solution().maxSubArray(nums));
//                int[] prefix = new int[nums.length];
//        int result = 0;
//        for(int i = 0; i < nums.length; i++){
//            if(i == 0){
//                prefix[i] = nums[i];
//                continue;
//            }
//            prefix[i] = nums[i] + prefix[i-1];
//        }
//        System.out.println(Arrays.toString(prefix));
        int[] suffix = new int[nums.length];
        for(int i = nums.length - 1;i >=0; i--) {
            if(i == nums.length - 1) {
                suffix[i] = nums[i];
                continue;
            }
            suffix[i] = suffix[i+1] + nums[i];
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(suffix));

    }

    static int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
//    static int[] nums = new int[]{1};
//    static int[] nums = new int[]{5,4,-1,7,8};

}
