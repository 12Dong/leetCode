package leetcode.pro46;

import java.util.LinkedList;
import java.util.List;

public class Solution3 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        boolean[] vis = new boolean[nums.length];
        dfs(ans, nums, new LinkedList<>(), vis);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, int[] nums, List<Integer> cur, boolean[] vis) {
        if(cur.size() == nums.length) {
            ans.add(new LinkedList<>(cur));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!vis[i]) {
                vis[i] = true;
                cur.add(nums[i]);
                dfs(ans, nums, cur, vis);
                cur.remove(cur.size() - 1);
                vis[i] = false;
            }
        }
    }
}
