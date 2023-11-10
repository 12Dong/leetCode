package leetcode.pro11;

public class Solution2 {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int ans = 0;
        while(l < r) {
            ans = Math.max(Math.min(height[l], height[r]) * (r - l), ans);
            if(height[l] >= height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return ans;
    }
}
