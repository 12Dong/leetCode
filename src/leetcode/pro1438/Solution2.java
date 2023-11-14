package leetcode.pro1438;

import java.util.TreeMap;

public class Solution2 {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> cntMap = new TreeMap<>();
        int ans = 1;
        int l = 0;
        int r = 1;
        cntMap.put(nums[0], 1);
        while(r < nums.length) {
            int min = cntMap.firstKey();
            int max = cntMap.lastKey();
            if(Math.abs(nums[r] - min) <= limit && Math.abs(nums[r] - max) <= limit) {
                cntMap.put(nums[r], cntMap.getOrDefault(nums[r], 0) + 1);
                r++;
            } else {
                while(l < r && (Math.abs(nums[r] - min) > limit || Math.abs(nums[r] - max) > limit)) {
                    int cnt = cntMap.get(nums[l]);
                    cnt--;
                    if(cnt == 0) {
                        cntMap.remove(nums[l]);
                    } else {
                        cntMap.put(nums[l], cnt);
                    }
                    l++;
                    if(l < r) {
                        min = cntMap.firstKey();
                        max = cntMap.lastKey();
                    }
                }
                cntMap.put(nums[r], cntMap.getOrDefault(nums[r], 0) + 1);
                r++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
