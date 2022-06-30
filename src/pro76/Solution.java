package pro76;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> compMap = new HashMap<>();
        for(int i = 0;i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int minLength = Integer.MAX_VALUE;
        int minL = 0;
        int minR = 0;
        int length = t.length();
        int left = 0;
        for(int right =0; right < t.length(); right++){
            if(map.containsKey(s.charAt(right))) {
                int cur = compMap.get(s.charAt(right));
                if(cur > 0) {
                    length--;
                }
                compMap.put(s.charAt(right), cur - 1);

                while(left < right && length == 0) {
                    if(right - left + 1 < minLength) {
                        minL = left;
                        minR = right;
                    }
                    if(map.containsKey(s.charAt(left))) {

                        compMap.put(s.charAt(left), compMap.get(s.charAt(left)) + 1);
                        int lCur = compMap.get(s.charAt(left));
                        if(lCur > 0) {
                            length++;
                        }

                    }
                    left++;
                }
            }
        }

        if(minLength == Integer.MIN_VALUE) {
            return "";
        } else {
            return s.substring(minL, minR);
        }
    }
}
