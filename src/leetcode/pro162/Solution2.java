package leetcode.pro162;

public class Solution2 {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int middle = (l + r) / 2;
            if(middle - 1 < 0 || middle + 1 == nums.length) {
                if(middle - 1 < 0 && middle + 1 == nums.length) {
                    return middle;
                } else if(middle - 1 < 0) {
                    if(nums[middle] > nums[middle + 1]) {
                        return middle;
                    } else {
                        l = middle + 1;
                    }
                } else {
                    if(nums[middle] > nums[middle - 1]) {
                        return middle;
                    } else {
                        r = middle - 1;
                    }
                }
            } else if(nums[middle - 1] < nums[middle] && nums[middle] > nums[middle + 1]) {
                return middle;
            } else if(nums[middle - 1] < nums[middle]) {
                l = middle + 1;
            } else {
                r = middle - 1;
            }
        }
        return 0;
    }
}
