package leetcode.pro300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        int[] ans = new int[2500];
        int length = 0;
        for(int i = 0; i < nums.length; i++) {
            if(length == 0) {
                ans[length] = nums[i];
                length++;
            } else {
                if(nums[i] > ans[length - 1]) {
                    ans[length] = nums[i];
                    length++;
                } else {
                    int index = binarySort(ans, length, nums[i]);
                    ans[index] = nums[i];
                }
            }
        }
        return length;
    }

    public static int binarySort(int[] array, int length, Integer num) {
        int l = 0;
        int r = length - 1;
        int ans = length - 1;
        while(l <= r) {
            int middle = (l + r) / 2;
            if(array[middle] >= num) {
                ans = middle;
                l = middle + 1;
            } else {
                r = middle - 1;
            }
        }
        return ans;
    }
}
