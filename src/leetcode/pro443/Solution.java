package leetcode.pro443;

public class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int r = 0;
        while(r < chars.length) {
            char c = chars[r++];
            int cnt = 1;
            while(r < chars.length && chars[r] == c)  {
                r++;
                cnt++;
            }
            if(cnt == 1) {
                chars[index++] = c;
            } else {
                chars[index++] = c;
                String sCnt = Integer.toString(cnt);
                for(int j = 0; j < sCnt.length(); j++) {
                    chars[index++] = sCnt.charAt(j);
                }
            }
        }
        return index;
    }
}
