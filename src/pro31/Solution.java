package pro31;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        boolean change = false;
        for(int i = nums.length - 1;i>=0;i--) {
            for(int j = i - 1; j>=0;j--) {
                if(nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    Arrays.sort(nums, j+1, nums.length);
                    change = true;
                    break;
                }
            }
            if(change) break;
        }
        if(!change) {
            int[] reverse = new int[nums.length];
            for(int i = nums.length - 1; i >=nums.length/2 ; i--) {
                int tmp = nums[i];
                nums[i] = nums[nums.length - i - 1];
                nums[nums.length - i - 1] = tmp;
            }
        }
    }

    public static void main(String[] argv) {
        new Solution().nextPermutation(new int[]{4,2,0,2,3,2,0});
    }
}
