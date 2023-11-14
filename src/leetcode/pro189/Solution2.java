package leetcode.pro189;

public class Solution2 {
    public void rotate(int[] nums, int k) {
      k = k % nums.length;
      for(int i = 0; i < nums.length / 2; i++) {
          int tmp = nums[i];
          nums[i] = nums[nums.length - 1 - i];
          nums[nums.length - 1 - i] = tmp;
      }
      // 翻转 前 k 个 数字
      for(int i = 0; i < k / 2; i++) {
          int tmp = nums[i];
          nums[i] = nums[k - 1 - i];
          nums[k - 1 - i] = tmp;
      }
      // 翻转 剩余数字
      for(int i = k; i < (k + nums.length) / 2; i++) {
          int tmp = nums[i];
          nums[i] = nums[nums.length - 1 - (i - k)];
          nums[nums.length -1 - (i - k)] = tmp;
      }
    }
}
