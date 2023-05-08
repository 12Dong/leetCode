package leetcode.pro1004;

public class Solution {

//    输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//    输出：6
//    解释：[1,1,1,0,0,1,1,1,1,1,1]
//    粗体数字从 0 翻转到 1，最长的子数组长度为 6。

//    [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1]

    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int ans = 0;
        int cnt = 0;
        while(r < nums.length) {
            if(nums[r] == 1) {
                cnt++;
                ans = Math.max(ans, cnt);
            } else {
                k--;
                while(k < 0) {
                    if(nums[l] == 0) {
                        k++;
                    }
                    cnt--;
                    l++;
                }
                cnt++;
                ans = Math.max(ans, cnt);
            }
            r++;
        }
        return Math.max(ans, cnt);
    }

    public static void main(String[] argv) {
//        System.out.println(new Solution().longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));

        System.out.println(new Solution().longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}
