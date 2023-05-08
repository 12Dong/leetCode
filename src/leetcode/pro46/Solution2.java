package leetcode.pro46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> cur = new ArrayList<>();
        List<Integer> rest = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            rest.add(nums[i]);
        }
        permute(cur, rest, ans);
        return ans;
    }

    public void permute(List<Integer> cur, List<Integer> rest, List<List<Integer>> ans) {
        if(rest.isEmpty()) {
            ans.add(new LinkedList<>(cur));
            return;
        }
        for(int i = 0; i < rest.size(); i++) {
            int curNum = rest.get(i);
            List<Integer> next = new LinkedList<>();
            next.addAll(rest.subList(0, i));
            if(i != rest.size() - 1) {
                next.addAll(rest.subList(i + 1, rest.size()));
            }
            cur.add(curNum);
            permute(cur, next, ans);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] argv) {
        new Solution2().permute(new int[]{1});
    }
}
