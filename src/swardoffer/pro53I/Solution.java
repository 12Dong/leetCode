package swardoffer.pro53I;

public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) {
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        int start = 0;
        while(l < r) {
            int middle = l + ((r - l) >> 1);
            if(nums[middle] > target) {
                r = middle;
            } else if(nums[middle] == target){
                r = middle;
                start = Math.min(start, middle);
            } else {
                l = middle + 1;
            }
        }
        int cnt = 0;
        while(r >= 0 && r < nums.length && nums[r] == target) {
            cnt++;
            r++;
        }
        return cnt;
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().search(new int[]{5,7,7,8,8,10}, 8));
    }
}
