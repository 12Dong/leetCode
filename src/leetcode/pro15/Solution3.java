package leetcode.pro15;

import java.util.*;

public class Solution3 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length;i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = - nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r) {
                if(nums[l] + nums[r] == target) {
                    List<Integer> ans = new LinkedList<>();
                    ans.add(nums[i]);
                    ans.add(nums[l]);
                    ans.add(nums[r]);
                    set.add(ans);
                    l++;
                    r--;
                } else if(nums[l] + nums[r] < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return new LinkedList<>(set);
    }
}
