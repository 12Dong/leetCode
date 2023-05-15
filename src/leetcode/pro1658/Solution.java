package leetcode.pro1658;

public class Solution {

    public int minOperations(int[] nums, int x) {
        int[] leftSum = new int[nums.length + 1];
        int[] rightSum = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            leftSum[i + 1] = leftSum[i] + nums[i];
        }
        for(int i = nums.length - 1; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i];
        }
        int ans = Integer.MAX_VALUE;
        for(int i = -1; i < nums.length; i++) {
            int rest = x - leftSum[i + 1];
            int r = nums.length;
            int l = i + 1;
            while(l <= r) {
                int middle = (l + r) / 2;
                if(rightSum[middle] == rest) {
                    ans = Math.min(ans, (i + 1) + (nums.length - middle));
                    break;
                } else if(rightSum[middle] > rest) {
                    l = middle + 1;
                } else {
                    r = middle - 1;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] argv) {
//        new Solution().minOperations(new int[]{1,1,4,2,3}, 5);
        new Solution().minOperations(new int[]{5,2,3,1,1}, 5);
    }
}
