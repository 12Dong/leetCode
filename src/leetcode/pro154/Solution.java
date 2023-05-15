package leetcode.pro154;

public class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length -1;
        while(l < r) {
            int middle = (l + r) / 2;
            if(nums[middle] < nums[r]){
                r = middle;
            } else if(nums[middle] > nums[r]){
                l = middle + 1;
            } else {
                r--;
            }
        }
        return nums[l];
    }


    public static void main(String[] argv) {
        new Solution().findMin(new int[]{2,2,2,2,2});
    }

}
