package leetcode.pro15;

import java.util.*;

public class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            int target = - nums[i];
            while(l < r) {
                int sum = nums[l] + nums[r];
                if(sum == target) {
                    List<Integer> tmp = Arrays.asList(nums[i], nums[l], nums[r]);
                    ans.add(tmp);
                    l++;
                    r--;
                } else if(sum < target) {
                    l++;
                } else {
                    r--;
                }
            }

        }
        return new LinkedList<>(ans);
    }

}
