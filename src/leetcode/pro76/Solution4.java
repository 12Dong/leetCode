package leetcode.pro76;

import java.util.HashMap;
import java.util.Map;

public class Solution4 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> cntMap = new HashMap<>();
        int cnt = t.length();
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            cntMap.put(c, cntMap.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int r = 0;
        String ans = "";
        while(r < s.length()) {
            char cur = s.charAt(r);
            // r 右移
            r++;
            // 新字符加入后是否能满足覆盖条件 cnt = 0
            if(cntMap.containsKey(cur)) {

                // 更新键值对 判断是否重复
                int curCnt = cntMap.get(cur);
                curCnt --;
                if(curCnt >= 0) {
                    cnt --;
                }
                cntMap.put(cur, curCnt);

                if(cnt == 0) {
                    // 满足条件了 不断缩小左边界 直至不满足条件为止
                    while(l < r && l < s.length() && cnt == 0) {
                        if(ans.equals("")) {
                           ans = s.substring(l, r);
                        } else {
                            String target = s.substring(l, r);
                            if(ans.length() > target.length()) {
                                ans = target;
                            }
                        }

                        //判断左边界是否在 t 中
                        char lc = s.charAt(l);
                        if(cntMap.containsKey(lc)) {
                            // 更新键值对 判断是否重复
                            int lcCnt = cntMap.get(lc);
                            lcCnt ++;
                            if(lcCnt > 0) {
                                cnt++;
                            }
                            cntMap.put(lc, lcCnt);
                        }
                        // 左边界右移
                        l++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution4().minWindow("aaa", "a");
    }
}
