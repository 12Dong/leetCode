package pro46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        ans.clear();
        List<Integer> stock = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            stock.add(nums[i]);
        }
        recursion(new LinkedList<>(), stock);
        return ans;
    }

    public static void main(String[] argv) {
        int[] nums = new int[]{1, 2, 3};
        new Solution().permute(nums);
    }

    public static void recursion(List<Integer> p, List<Integer> stock) {
        if(stock.isEmpty()) {
            List<Integer> a = new LinkedList<>(p);
            ans.add(a);
            return;
        }
        for(int i = 0; i < stock.size(); i ++) {
            List<Integer> curStock = new LinkedList<>(stock);
            curStock.remove(i);
            p.add(stock.get(i));
            recursion(p, curStock);
            p.remove(p.size() -1);

        }

    }
}
