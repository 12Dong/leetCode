package leetcode.pro35;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int ans = nums.length;
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int middle = (l + r) / 2;
            if(nums[middle] == target) {
                return middle;
            } else if(nums[middle] < target) {
                l = middle + 1;
            } else {
                ans = middle;
                r = middle - 1;
            }
        }
        return ans;
    }
}
