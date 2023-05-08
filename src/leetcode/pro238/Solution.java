package leetcode.pro238;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefixMult = 1;
        int zeroCount = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0 ) {
                zeroCount ++;
            } else {
                prefixMult *= nums[i];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(zeroCount > 1) {
                nums[i] = 0;
            } else if(zeroCount == 1) {
                if(nums[i] != 0) {
                    nums[i] = 0;
                } else {
                    nums[i] = prefixMult;
                }
            } else {
                 nums[i] = prefixMult / nums[i];
            }
        }
        return nums;
    }
}
