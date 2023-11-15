package swardoffer.pro39;

public class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 1;
        int ans = nums[0];
        int index = 1;
        while(index < nums.length) {
            if(nums[index] == ans) {
                cnt++;
                index++;
            } else {
                cnt--;
                index++;
                if(cnt == 0) {
                    ans = nums[index];
                    cnt++;
                    index++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().majorityElement(new int[]{1,2,1}));
    }
}
