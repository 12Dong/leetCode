package pro31;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        boolean change = false;
        for(int i = nums.length - 1;i>=0;i--) {
            if(i < 1) continue;;
            if(nums[i] > nums[i-1]) {
                int index = i;
                int val = nums[index];
                for(int j = i; j < nums.length; j++) {
                    if(nums[j] > nums[i-1] && nums[j] < val) {
                        index = j;
                        val = nums[j];
                    }
                }
                int tmp = nums[i-1];
                nums[i-1] = nums[index];
                nums[index] = tmp;
                Arrays.sort(nums, i, nums.length);
                change = true;
            }
            if(change) break;
        }
        if(!change) {
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
