package leetcode.pro33;

import java.util.Arrays;

public class Solution3 {
    public int search(int[] nums, int target) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int l = 0;
        int r = nums.length - 1;
        while(l < r) {
            int middle = (l + r) /2;
            if(nums[l] <= nums[middle]) {
                if(nums[l] <= target && target <= nums[middle]) {
                    r = middle;
                } else {
                    l = middle + 1;
                }
            } else {
                if(nums[middle] <= target && target <= nums[nums.length - 1]) {
                    l = middle;
                } else {
                    r = middle - 1;
                }
            }
        }
        return -1;
    }

}
