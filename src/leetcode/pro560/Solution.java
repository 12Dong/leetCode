package leetcode.pro560;

public class Solution {

    public int subarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                preSum[i] = nums[i];
            } else {
                preSum[i] = preSum[i - 1] + nums[i];
            }
        }
        int cnt = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++)  {
                if(i == 0) {
                    if(preSum[j] == k) {
                        cnt++;
                    }
                } else {
                    if(preSum[j] - preSum[i - 1] == k) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
