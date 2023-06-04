package leetcode.pro1031;

public class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        if(firstLen > secondLen) {
            return maxSumTwoNoOverlap(nums, secondLen, firstLen);
        }

        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        int[] dp3 = new int[nums.length];
        int[] dp4 = new int[nums.length];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum+= nums[i];
            if(i >= firstLen) {
                sum -= nums[i - firstLen];
            }
            if(i >= firstLen - 1) {
                if(i - 1 >= 0) {
                    dp1[i] = Math.max(dp1[i - 1], sum);
                } else {
                    dp1[i] = sum;
                }
            }
        }

        sum = 0;
        for(int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];

            if(i <= nums.length - secondLen - 1) {
                sum -= nums[i + secondLen];
            }

            if(i <= nums.length - secondLen) {
                if(i + 1 < nums.length) {
                    dp3[i] = Math.max(dp3[i + 1], sum);
                } else {
                    dp3[i] = sum;
                }
            }
        }



        sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum+= nums[i];
            if(i >= secondLen) {
                sum -= nums[i - secondLen];
            }
            if(i >= secondLen - 1) {
                if(i - 1 >= 0) {
                    dp2[i] = Math.max(dp2[i - 1], sum);
                } else {
                    dp2[i] = sum;
                }
            }
        }

        sum = 0;
        for(int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            if(i <= nums.length - firstLen - 1) {
                sum -= nums[i + firstLen];
            }

            if(i <= nums.length - firstLen) {
                if(i + 1 < nums.length) {
                    dp4[i] = Math.max(dp4[i + 1], sum);
                } else {
                    dp4[i] = sum;
                }
            }
        }

        int ans = 0;
        for(int i = firstLen - 1; i < nums.length; i++) {
            if(i + 1 < nums.length) {
                ans = Math.max(ans, dp1[i] + dp3[i + 1]);
            }
        }

        for(int i = secondLen - 1; i < nums.length; i++) {
            if(i + 1 < nums.length) {
                ans = Math.max(ans, dp2[i] + dp4[i + 1]);
            }
        }

        return ans;
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().maxSumTwoNoOverlap(new int[]{0,6,5,2,2,5,1,9,4}, 1, 2));
    }
}
