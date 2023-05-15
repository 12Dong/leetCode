package leetcode.pro1658;

public class Solution2 {

    public int minOperations(int[] nums, int x) {
        int[] leftSum = new int[nums.length + 1];
        int[] rightSum = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            leftSum[i + 1] = leftSum[i] + nums[i];
        }
        for(int i = nums.length - 1; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i];
        }
        int l = 0;
        int r = 0;
        int ans = Integer.MAX_VALUE;
        while(r != nums.length + 1 && l != nums.length + 1 && l <= r) {
            if(leftSum[l] + rightSum[r] > x) {
                r++;
            } else if(leftSum[l] + rightSum[r] == x){
                ans = Math.min(l + (nums.length - r), ans);
                l++;
                r++;
            } else {
                l++;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] argv) {
//        System.out.println(new Solution2().minOperations(new int[]{1,1,4,2,3}, 5));
//        System.out.println(new Solution2().minOperations(new int[]{5,2,3,1,1,}, 5));

//        System.out.println(new Solution2().minOperations(new int[]{1,1}, 3));
        System.out.println(new Solution2().minOperations(new int[]{8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309}, 134365));

    }
}
