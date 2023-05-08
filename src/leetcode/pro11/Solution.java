package leetcode.pro11;

public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while(left != right) {
            ans = Math.max((Math.min(height[left], height[right]) * (right - left + 1)), ans);
            if(height[left] < height[right]) {
                left ++;
            } else {
                right --;
            }
        }
        return ans;
    }
}
