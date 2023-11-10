package leetcode.pro283;

public class Solution2 {
    public void moveZeroes(int[] nums) {
        int cnt = 0;
        int index = 0;
        for(int num : nums) {
            if(num == 0) {
                cnt++;
            } else {
                nums[index] = num;
                index++;
            }
        }
        for(; index < nums.length; index++) {
            nums[index] = 0;
        }

    }
}
