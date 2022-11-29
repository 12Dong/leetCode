package pro76;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> cntMap = new HashMap<>();
        int cnt = t.length();
        String ans = "";
        for(int i = 0; i < t.length(); i ++) {
            cntMap.put(t.charAt(i), cntMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int l = 0, r = 0;
        for(; r < s.length(); r++) {
            char curR = s.charAt(r);
            if(cntMap.containsKey(curR)) {
                int cntR = cntMap.get(curR);
                if(cntR > 0) {
                    cnt--;
                }
                cntR--;
                cntMap.put(curR, cntR);

                if(cnt == 0) {
                    while(l <= r && cnt <= 0) {
                        if(ans.equals("")) {
                            ans = s.substring(l, r + 1);
                        } else {
                            if(ans.length() > (r - l + 1)) {
                                ans = s.substring(l, r+1);
                            }
                        }

                        char curL = s.charAt(l);
                        if(cntMap.containsKey(curL)) {
                            int cntL = cntMap.get(curL);
                            cntL++;
                            if(cntL > 0) {
                                cnt++;
                            }
                            cntMap.put(curL, cntL);
                        }
                        l++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution3().minWindow("ADOBECODEBANC", "ABC");
    }
}
