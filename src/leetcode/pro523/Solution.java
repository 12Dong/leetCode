package leetcode.pro523;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum = sum % k;
            if (sum == 0 && i != 0) {
                return true;
            } else if (prefixSumMap.containsKey(sum)) {
                int index = prefixSumMap.get(sum);
                if (i - index != 1) {
                    return true;
                }
            } else {
                prefixSumMap.put(sum, i);
            }
        }
        return false;
    }

    public static void main(String[] argv) {
        new Solution().checkSubarraySum(new int[]{23,2,4,6,6}, 7);
    }

//    [23,2,4,6,6]   7
//    [2 ,4,1,0,6]
}
