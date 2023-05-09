package leetcode.pro18;

import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        long t = target;
        Arrays.sort(nums);
        if(nums.length < 4) {
            return new LinkedList<>();
        }
        Set<List<Integer>> ans = new HashSet<>();
        for(int a = 0; a <= nums.length - 4; a++) {
            if(a > 0 && nums[a] == nums[a-1]) continue;
            for(int b = a + 1; b <= nums.length - 3; b++) {
                int c = b + 1;
                int d= nums.length - 1;
                long tt = t - nums[a] - nums[b];
                while(c < d) {
                    long sum = nums[c] + nums[d];
                    if(sum == tt) {
                        List<Integer> cur = new LinkedList<>();
                        cur.add(nums[a]);
                        cur.add(nums[b]);
                        cur.add(nums[c]);
                        cur.add(nums[d]);
                        ans.add(cur);
                        c++;
                        d--;
                    } else if(sum < tt) {
                        c++;
                    } else {
                        d--;
                    }
                }
            }
        }
        List<List<Integer>> aa = new LinkedList<>();
        for(List<Integer> set : ans) {
            aa.add(new LinkedList<>(set));
        }
        return aa;
    }

    public static void main(String[] argv) {
        new Solution().fourSum(new int[]{1,0,-1,0,-2,2}, 0);
    }
}
