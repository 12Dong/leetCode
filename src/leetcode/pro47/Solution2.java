package leetcode.pro47;

import java.util.*;

public class Solution2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        Set<List<Integer>> vis = new HashSet<>();
        Arrays.sort(nums);
        dfs(nums,  ans, new LinkedList<>(), vis);
        return ans;
    }

    public void dfs(int[] nums, List<List<Integer>> ans, List<Integer> cur, Set<List<Integer>> vis) {
        if(nums.length == 0) {
            ans.add(new LinkedList<>(cur));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            int[] newNums = new int[nums.length - 1];
            int index = 0;
            for(; index< i; index++) {
                newNums[index] = nums[index];
            }
            for(;index + 1 < nums.length; index++) {
                newNums[index] = nums[index + 1];
            }

            cur.add(nums[i]);
            if(!vis.contains(cur)) {
                vis.add(cur);
                dfs(newNums, ans, cur, vis);
            }
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] argv) {
        new Solution2().permuteUnique(new int[]{1,1, 2});
    }
}
