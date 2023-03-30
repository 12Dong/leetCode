package pro283;

public class Solution {
    public void moveZeroes(int[] nums) {
        int a = 0;
        int b = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[a] = nums[i];
                a++;
            }
        }
        for(; a < nums.length; a++) {
            nums[a] = 0;
        }
    }
}
