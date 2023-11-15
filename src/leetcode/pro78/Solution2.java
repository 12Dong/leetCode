package leetcode.pro78;

import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        boolean[] vis = new boolean[nums.length];
        dfs(ans, nums, 0, new LinkedList<>(), vis);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, int[] nums, int index, List<Integer> cur, boolean[] vis) {
        if(index == nums.length) {
            ans.add(new LinkedList<>(cur));
            return;
        }
        for(int i = index; i < nums.length; i++) {
            if(index != 0 && nums[index] == nums[index - 1]) {
                continue;
            }
            if(!vis[i]) {
                // 取 nums[i]
                vis[i] = true;
                cur.add(nums[i]);
                dfs(ans, nums, i + 1, cur, vis);
                cur.remove(cur.size() - 1);
                vis[i] = false;
                // 不取 nums[i]
            }
        }
        dfs(ans, nums, nums.length, cur, vis);
    }
}
