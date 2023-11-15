package leetcode.pro1493;

public class Solution {
    public int longestSubarray(int[] nums) {
        int now = 0;
        int last = 0;
        int ans = 0;
        int index = 0;
        boolean flag = false;
        while(index < nums.length) {
            if(nums[index] == 1) {
                now++;
                index++;
            } else {
                flag = true;
                if(last == 0) {
                    ans = Math.max(ans, now);
                    while(index < nums.length && nums[index] == 0) {
                        index++;
                        last = now;
                        now = 0;
                    }

                } else {
                    ans = Math.max(ans, now + last);
                    while(index < nums.length && nums[index] == 0) {
                        index++;
                        last = now;
                        now = 0;
                    }

                }
            }
        }
        if(last == 0) {
            if(flag== false) {
                ans = Math.max(ans, now - 1);
            } else {
                ans = Math.max(ans, now);
            }
        } else {
            ans = Math.max(ans, now + last);
            last = now;
            now = 0;
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution().longestSubarray(new int[]{1,1,0,0,1,1,1,0,1});
    }
}
