package leetcode.pro187;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int P = 13131;
        long[] hash = new long[s.length() + 1];
        long[] p = new long[s.length() + 1];
        Map<Long, Integer> cntMap = new HashMap<>();
        p[0] = 1;
        for(int i = 1; i <= s.length(); i++) {
            hash[i] = hash[i - 1] * P + s.charAt(i - 1);
            p[i] = p[i - 1] * P;
        }
        List<String> ans = new LinkedList<>();
        for(int i = 1; i + 10 - 1 <= s.length(); i++) {
            int j = i + 10 - 1;
            long h = hash[j] - hash[i - 1] * p[j - i + 1];
            int cnt = cntMap.getOrDefault(h, 0);
            if(cnt == 1) {
                ans.add(s.substring(i - 1, j));
            }
            cntMap.put(h, cnt + 1);
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }
}
