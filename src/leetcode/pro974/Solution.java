package leetcode.pro974;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        cntMap.put(0, 1);
        int ans = 0;
        int prefixMod = 0;
        for(int i = 0; i < nums.length; i++) {
            prefixMod = (prefixMod + nums[i]) % k;
            if(prefixMod < 0) {
                prefixMod += k;
            }
            int hPrefixMod = (cntMap.getOrDefault(prefixMod, 0));
            ans += hPrefixMod;
            cntMap.put(prefixMod, hPrefixMod + 1);
        }
        return ans;
    }
}
