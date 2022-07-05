package pro162;

public class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int ans = 0;
        while(l <= r) {
            int middle = (l+r) / 2;
            long lVal = middle - 1 >= 0 ? nums[middle - 1] : Long.MIN_VALUE;
            long rVal = middle + 1 < nums.length ? nums[middle + 1] : Long.MIN_VALUE;
            if(nums[middle] > lVal && nums[middle] > rVal){
                return middle;
            } else if (nums[middle] < rVal) {
                l = middle + 1;
            } else if(nums[middle] < lVal) {
                r = middle - 1;
            }
        }
        return ans;
    }
}
