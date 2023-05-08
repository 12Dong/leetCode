package leetcode.pro454;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer , Integer> count12 = new HashMap<>();
        Map<Integer, Integer> count34 = new HashMap<>();
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                count12.put(nums1[i] + nums2[j], count12.getOrDefault(nums1[i] + nums2[j], 0) + 1);
            }
        }
        for(int i = 0; i < nums3.length; i++) {
            for(int j = 0; j < nums4.length; j++) {
                count34.put(nums3[i] + nums4[j], count34.getOrDefault(nums3[i] + nums4[j], 0) + 1);
            }
        }

        int ans = 0;
        for(Integer num : count12.keySet()) {
            if (count34.containsKey(-num)) {
                ans += count12.get(num) * count34.get(-num);
            }
        }
        return ans;
    }
}
