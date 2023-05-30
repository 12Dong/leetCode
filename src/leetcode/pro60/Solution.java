package leetcode.pro60;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public String getPermutation(int n, int k) {
        int cnt = 0;
        String ans = "";
        int cur = 0;
        List<Integer> nums = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            nums.add(i);
        }
        return dfs(nums, k, ans);
    }

    public int p(int p) {
        int ans = 1;
        for(int i = 1; i <= p;i++) {
            ans *= i;
        }
        return ans;
    }

    public String dfs(List<Integer> nums, int k, String prefix) {
        if(k == 0) {
            for(Integer num : nums) {
                prefix += num;
            }
            return prefix;
        }
        int cnt = 0;
        int index = 0;
        while(cnt + p(nums.size() - 1) <= k) {
            if(cnt == k) {
                Integer n = nums.remove(index);
                prefix += n;
                for(int i = nums.size() - 1; i >= 0; i--) {
                    prefix += nums.get(i);
                }
                return prefix;
            }
            index++;
            if(index >= nums.size()) {
                break;
            }
        }
        Integer n = nums.remove(index);
        return dfs(nums, k - cnt, prefix + n);

    }

    public static void main(String[] argv) {
        System.out.println(new Solution().getPermutation(3, 2));
    }
}
