package leetcode.pro76;

import java.util.HashMap;
import java.util.Map;

public class Solution5 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> cntMap = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            cntMap.put(c, cntMap.getOrDefault(c, 0) + 1);
        }
        int cnt = t.length();
        int l = 0;
        int r = 0;
        String ans = "";
        while(r < s.length()) {
            Character rC = s.charAt(r);
            // 检查是否满足条件 or 超出 map 限制
            if(cntMap.containsKey(rC)) {
                int rCount = cntMap.get(rC);
                rCount--;
                cntMap.put(rC, rCount);
                if(rCount >= 0) {
                    cnt--;
                    if(cnt == 0) {
                        String tmpAns = s.substring(l, r + 1);
                        if(ans.equals("") || tmpAns.length() < ans.length()) {
                            ans = tmpAns;
                        }
                        // l 向右 缩小答案
                        while(l < r && cnt == 0) {
                            Character lC = s.charAt(l);
                            if(cntMap.containsKey(lC)) {
                                int lCount = cntMap.get(lC);
                                lCount++;
                                cntMap.put(lC, lCount);
                                if(lCount > 0) {
                                    cnt++;
                                }
                            } else {

                            }
                            l++;
                            if(cnt == 0) {
                                tmpAns = s.substring(l, r + 1);
                                if(ans.equals("") || tmpAns.length() < ans.length()) {
                                    ans = tmpAns;
                                }
                            }
                        }
                    }
                }
            } else {
                // 不满足条件 继续向右找
            }
            r++;
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution5().minWindow("ADOBECODEBANC", "ABC");
    }
}
