package leetcode.pro974;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        cntMap.put(0, 1);
        int sum = 0;
        int ans = 0;
        for(int num : nums) {
            sum = (sum + num % k + k) % k;
            if(cntMap.containsKey(sum)) {
                ans += cntMap.get(sum);
            }
            cntMap.put(sum, cntMap.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution3().subarraysDivByK(new int[]{4, 5 ,0,  -2, -3, 1}, 5);
    }
}
