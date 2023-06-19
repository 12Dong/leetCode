package leetcode.pro90;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new LinkedList<>(), ans);
        return ans;
    }

    public void dfs(int[] nums, int curL, List<Integer> list, List<List<Integer>> ans) {
        if(curL ==nums.length) {
            ans.add(new LinkedList<>(list));
            return;
        }
        for(int i = curL; i < nums.length; i++) {
            if(i > curL && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            dfs(nums, i + 1, list, ans);
            list.remove(list.size() - 1);
        }
        dfs(nums, nums.length, list, ans);
    }
}
