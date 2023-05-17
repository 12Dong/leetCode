package leetcode.pro560;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public int subarraySum(int[] nums, int k) {
                Map<Integer, Integer> prefixSumMap = new HashMap<>();
                int sum = 0;
                int ans = 0;
                prefixSumMap.put(0, 1);
                for (int i = 0; i < nums.length; i++) {
                    sum += nums[i];
                    if(prefixSumMap.containsKey(sum - k)) {
                        ans += prefixSumMap.get(sum - k);
                    }
                    prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
                }
                return ans;
        }
}
