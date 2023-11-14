package leetcode.pro128;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution3 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> vis = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for(Integer num : set) {
            if(vis.contains(num)) {
                continue;
            }
            int length = 1;
            vis.add(num);
            int next = num + 1;
            while(set.contains(next)) {
                vis.add(next);
                next++;
                length++;
            }
            next = num - 1;
            while(set.contains(next)) {
                vis.add(next);
                next--;
                length++;
            }
            ans = Math.max(ans, length);
        }
        return ans;

    }
}
