package pro334;

public class Solution {

    public boolean increasingTriplet(int[] nums) {
        int min1 = nums[0];
        int min2 = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > min2) {
                return true;
            } else if(nums[i] > min1) {
                min2 = nums[i];
            } else {
                min1 = nums[i];
            }
        }
        return false;
    }
}
