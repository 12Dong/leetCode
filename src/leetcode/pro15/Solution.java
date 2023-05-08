package leetcode.pro15;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int val = - nums[i];
            if(i + 1 >= nums.length) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r) {
                if(nums[l] + nums[r] < val) {
                    l++;
                } else if(nums[l] + nums[r] > val) {
                    r--;
                } else {
                    List<Integer> cur = Arrays.asList(nums[i], nums[l], nums[r]);
                    ans.add(cur);
                    do {
                        l++;
                    } while ((l < nums.length && nums[l] == nums[l - 1]));
                    do {
                        r--;
                    } while(r >= 0 && nums[r] == nums[r + 1]);

                }
            }
        }
        List list = new LinkedList<>();
        list.addAll(ans);
        return list;
    }

    public static void main(String[] argv) {
        new Solution().threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}
