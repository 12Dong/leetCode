package leetcode.pro149;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxPoints(int[][] points) {
        int ans = 0;
        for(int i = 0; i < points.length; i++) {
            Map<String, Integer> cntMap = new HashMap<>();
            for(int j = i + 1; j < points.length; j++) {
                int a = points[i][0] - points[j][0];
                int b = points[i][1] - points[j][1];
                int k = gcd(a,b);
                String key = (a/k) + "_" + (b/k);
                cntMap.put(key, cntMap.getOrDefault(key, 0) + 1);

            }

            for(Map.Entry<String, Integer> entry : cntMap.entrySet()) {
                ans = Math.max(ans, entry.getValue());
            }
        }

        return ans + 1;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }
}
