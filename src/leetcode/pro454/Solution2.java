package leetcode.pro454;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> cntMap1 = new HashMap<>();
        Map<Integer, Integer> cntMap2 = new HashMap<>();
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                cntMap1.put(sum, cntMap1.getOrDefault(sum, 0) + 1);
            }
        }

        for(int i = 0; i < nums3.length; i++) {
            for(int j = 0; j < nums4.length; j++) {
                int sum = nums3[i] + nums4[j];
                cntMap1.put(sum, cntMap2.getOrDefault(sum, 0) + 1);
            }
        }

        int ans = 0;
        for(Map.Entry<Integer, Integer> entry : cntMap1.entrySet()) {
            int sum = entry.getKey();
            if(cntMap2.containsKey(-sum)) {
                ans += (entry.getValue() * cntMap2.get(-sum));
            }
        }
        return ans;
    }
}
