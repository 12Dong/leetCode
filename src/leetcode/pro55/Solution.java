package leetcode.pro55;

public class Solution {

    public boolean canJump(int[] nums) {
        boolean[] vis = new boolean[nums.length];
        int avaiable = 0;
        vis[0] = true;
        for(int i = 0; i < nums.length; i++) {
            if(i <= avaiable) {
                avaiable = Math.max(avaiable, i + nums[i]);
            } else {
                return false;
            }
        }
        return true;
    }
}
