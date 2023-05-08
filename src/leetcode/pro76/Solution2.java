package leetcode.pro76;

import java.util.HashMap;

public class Solution2 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> cntMap = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            cntMap.put(t.charAt(i), cntMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        Integer minLength = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        String ans = "";
        int currentCnt = t.length();
        // currentCnt 到 0 说明 当前l、r满足 覆盖子串
        for(int i = 0; i < s.length(); i++) {
            if(cntMap.containsKey(s.charAt(i))) {
                int cnt = cntMap.get(s.charAt(i));
                if(cnt > 0) {
                    currentCnt--;
                }
                cntMap.put(s.charAt(i), cntMap.get(s.charAt(i)) - 1);
                r = i;
                if(currentCnt == 0) {
                    while(l <= r) {
                        if(minLength > (r-l+1)) {
                            ans = s.substring(l, r + 1);
                            minLength = r - l + 1;
                        }
                        if(cntMap.containsKey(s.charAt(l))) {
                            int lCnt = cntMap.get(s.charAt(l));
                            lCnt++;
                            cntMap.put(s.charAt(l), lCnt);
                            if(lCnt > 0) {
                                currentCnt++;
                            }
                        }

                        l++;
                        if(currentCnt > 0) {
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution2().minWindow("a", "a");
    }
}
