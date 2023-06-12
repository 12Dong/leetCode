package leetcode.pro442;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == i + 1) {
                continue;
            }
            int curValue = nums[i];
            int curLocation = curValue - 1;
            while(nums[curLocation] != curValue) {
                int nextValue = nums[curLocation];
                nums[curLocation] = curValue;
                curValue = nextValue;
                curLocation = curValue - 1;
                nums[i] = curValue;
            }

        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }


    public static void main(String[] argv) {
        new Solution().findDuplicates(new int[]{2,1});
    }
}
