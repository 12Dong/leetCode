package leetcode.pro16;

import java.util.Arrays;

public class Solution {
//    [4,0,5,-5,3,3,0,-4,-5]
//    -5 -5 -4 0 0 3 3 4 5
//      -2
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i <= nums.length -2 ; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if(sum == target) {
                    return sum;
                } else if(sum < target) {
                    start++;
                } else {
                    end --;
                }
                if(Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
            }
        }
        return ans;
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().threeSumClosest(new int[]{0,3,97,102,200}, 300));
    }
}
//[0,3,97,102,200]
//300