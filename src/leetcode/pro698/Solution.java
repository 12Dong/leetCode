package leetcode.pro698;

import java.util.Arrays;

public class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(sum % k != 0) {
            return false;
        }
        int target = sum / k;
        Arrays.sort(nums);
        result = false;
        return dfs(nums.length - 1, 0, target, 0, k, new boolean[nums.length], nums);
//        return result;
    }

    static boolean result = false;
    public boolean dfs(int curL, int curV, int target, int cnt, int k, boolean[] vis, int[] nums) {
        if(cnt == k) {
            result = true;
            return true;
        }

        if(curV == target) {
            return dfs(vis.length - 1, 0, target, cnt + 1, k, vis, nums);

        }

        for(int i = curL; i >= 0; i--) {
            if(vis[i]) {
                continue;
            }

            if(curV + nums[i] > target) {
                continue;
            }

            vis[i] = true;
            if(dfs(i, curV + nums[i], target, cnt, k, vis, nums)) {
                return true;
            }
            vis[i] = false;

            if(curV == 0) {
                return false;
            }
        }
        return false;
    }
}
