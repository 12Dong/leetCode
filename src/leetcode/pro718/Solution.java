package leetcode.pro718;

import java.util.*;

public class Solution {

    public int findLength(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        // dp[i][j] 以 nums1[i] 结尾 以 nums2[j]结尾的最大长度子数组
        int[][] dp = new int[length1 + 1][length2 + 1];
        for(int i = 0; i<= length1; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i <= length1; i++){
            dp[i][0] = 0;
        }

        for(int j = 0; j <=length2; j++){
            dp[0][j] = 0;
        }

        HashSet<Integer> resultString = new HashSet<>();
        int result = 0;
        for(int i = 1; i <= length1; i++){
            for(int j = 1; j <= length2; j++){
                if(nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                    HashSet hashSet = new HashSet();

                    result = Math.max(result, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return result;
    }

    public static void main(String[] argv){
        System.out.println(new Solution().findLength(nums1, nums2));
    }

//    static int[] nums1 = new int[]{1,2,3,2,1};
//    static int[] nums1 = new int[]{0, 1, 1, 1, 1};
    static int[] nums1 = new int[]{0, 0, 0, 0, 0};
//    static int[] nums2 = new int[]{3,2,1,4,7};
//    static int[] nums2 = new int[]{1, 0, 1, 0, 1};
static int[] nums2 = new int[]{0, 0, 0, 0, 0};

}
