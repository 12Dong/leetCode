package leetcode.pro78;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> first = new LinkedList<>();
        ans.add(first);
        for(int i = 0; i < nums.length; i++) {
            List<Integer> newL = new LinkedList<>(first);
            newL.add(nums[i]);
            ans.add(newL);
            dfs(newL, nums, i, ans);
        }
        return ans;
    }

    public static void dfs(List<Integer> cur, int[] nums, int index, List<List<Integer>> ans) {
        for(int i = index+1; i < nums.length; i++) {
            List<Integer> newL = new LinkedList<>(cur);
            newL.add(nums[i]);
            ans.add(newL);
            dfs(newL, nums, i, ans);
        }
    }

    public static void main(String[] arv){
        new Solution().subsets(nums);
    }

    public static int[] nums = new int[]{1,2,3};
}
