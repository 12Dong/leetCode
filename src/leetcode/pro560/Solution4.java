package leetcode.pro560;

import java.util.HashMap;
import java.util.Map;

public class Solution4 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSumCntMap = new HashMap<>();
        int ans = 0;
        int sum = 0;
        preSumCntMap.put(0, 1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int target = sum - k;
            ans += preSumCntMap.getOrDefault(target , 0);
            preSumCntMap.put(sum, preSumCntMap.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
