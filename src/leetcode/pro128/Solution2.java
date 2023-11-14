package leetcode.pro128;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution2 {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> ll = new HashMap<>();
        for(int num : nums) {
            set.add(num);
        }
        int ans = 1;
        for(Integer num : set) {
            if(!set.contains(num - 1)) {
                int cur = num;
                while(set.contains(cur + 1)) {
                    cur = cur + 1;
                }
                ans = Math.max(ans, cur - num + 1);
            } else {
                continue;
            }
        }
        return ans;
    }
}
