package leetcode.pro90;

import java.util.*;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        dfs(nums, 0, new LinkedList<>(), ans, new HashSet<>());
        return new LinkedList<>(ans);
    }

    public void dfs(int[] nums, int index, List<Integer> cur, Set<List<Integer>> ans, Set<List<Integer>> vis) {
        if(index == nums.length) {
            ans.add(new LinkedList<>(cur));
            return;
        }
        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            // 选中 i
            cur.add(nums[i]);
            // 其他路径访问过
            if(vis.contains(cur)) {

            } else {
                vis.add(cur);
                dfs(nums, i + 1, cur, ans, vis);
            }
            cur.remove(cur.size() - 1);
            // 不选 i
//            dfs(nums, i + 1, cur, ans, vis);
        }
    }
}
