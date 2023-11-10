package aModule;

public class Solution {

    public static int binary(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int middle = l + (r - l) / 2;
            if(nums[middle] == target) {
                return middle;
            } else if(nums[middle] < target) {
                l = middle + 1;
            } else {
                r = middle - 1;
            }
        }
        return -1;
    }



    // 1 1 1 1 0 -> 1 1 1 1
    // 1 1 1 1 1 -> 1 1 1 1
    // 14 / 2 = 7
    // 15 / 2 = 7
}
