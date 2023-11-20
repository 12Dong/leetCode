package leetcode.pro34;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1,-1};
        int l = 0;
        int r = nums.length - 1;
        int location = -1;
        while(l <= r) {
            int middle = (l + r) / 2;
            if(nums[middle] < target) {
                l = middle + 1;
                location = middle;
            } else {
                r = middle - 1;
            }
        }
        if(location + 1 < nums.length && nums[location + 1] == target) {
            ans[0] = location + 1;
        }
        location = nums.length;
        l = 0;
        r = nums.length - 1;
        while(l <= r) {
            int middle = (l + r) / 2;
            if(nums[middle] <= target) {
                l = middle + 1;
            } else {
                r = middle - 1;
                location = middle;
            }
        }
        if(location -1 >= 0 && nums[location - 1] == target) {
            ans[1] = location - 1;
        }
        return ans;
    }
}
