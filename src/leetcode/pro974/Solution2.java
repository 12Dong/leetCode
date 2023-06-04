package leetcode.pro974;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        int sum = 0;
        int ans = 0;
        cntMap.put(0, 1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum = ((sum) % k + k)%k;
            if(cntMap.containsKey((sum) % k)) {
                ans+= cntMap.get(sum % k);
                cntMap.put(sum, cntMap.getOrDefault(sum, 0) + 1);
            } else {
                cntMap.put(sum, cntMap.getOrDefault(sum, 0) + 1);
            }
        }
        return ans;
    }

    public static void main(String[] argv) {
//        System.out.println(new Solution2().subarraysDivByK(new int[]{0,0,0}, 2));
//        System.out.println(new Solution2().subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5));
//        System.out.println(new Solution2().subarraysDivByK(new int[]{5}, 9));
        System.out.println(new Solution2().subarraysDivByK(new int[]{7, 4, -10}, 5));

    }
}
