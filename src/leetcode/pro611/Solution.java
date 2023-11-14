package leetcode.pro611;

import java.util.Arrays;

public class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i = nums.length - 1; i >= 0; i--) {
            for(int j = i - 1; j >= 0; j--) {
                int bigThan = nums[i] - nums[j];
                int index = findBigThan(nums, bigThan, j);
                if(index == Integer.MAX_VALUE) {
                    break;
                } else {
                    ans += (j - 1 - index + 1);
                }
            }
        }
        return ans;
    }

    public int findBigThan(int[] nums, int target,int end) {
        int l = 0;
        int r = end - 1;
        int ans = Integer.MAX_VALUE;
        while(l <= r) {
            int middle = (l + r) / 2;
            if(nums[middle] > target) {
                ans = Math.min(ans, middle);
                r = middle - 1;
            } else if(nums[middle] < target) {
                l = middle + 1;
            } else {
                l = middle + 1;
            }
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution().triangleNumber(new int[]{2,2,3,4});
    }
    // 2 3 4 4
    // 2 3 4
    // 3 4 4
}
