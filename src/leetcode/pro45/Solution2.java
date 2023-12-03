package leetcode.pro45;

public class Solution2 {
    public int jump(int[] nums) {
        int ans = 0;
        int next = 0;
        int tmp = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i <= next) {
                tmp = Math.max(tmp, i + nums[i]);
                if(i == next) {
                    next = tmp;
                    ans++;
                }
            }

        }
        if(nums.length <= tmp) {
            ans++;
        }
        return ans;
    }
}
