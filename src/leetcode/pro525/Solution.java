package leetcode.pro525;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> valLocation = new HashMap<>();
        valLocation.put(0, -1);
        int sum = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                nums[i] = -1;
            }
            sum += nums[i];
            if(valLocation.containsKey(sum)) {
                ans = Math.max(ans, i - valLocation.get(sum));
            } else {
                valLocation.put(sum, i);
            }

        }
        return ans;
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().findMaxLength(new int[]{0,1,0}));
    }
}
