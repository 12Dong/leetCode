package leetcode.pro384;

import java.util.Arrays;
import java.util.Random;

public class Solution {

    int[] nums;

    int length;

    Random random = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
        this.length = nums.length;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] ans = Arrays.copyOf(nums, length);
        for(int i = length - 1; i >= 0; i--) {
            int location = random.nextInt(i + 1);
            int tmp = ans[location];
            ans[location] = ans[i];
            ans[i] = tmp;
        }
        return ans;
    }
}
