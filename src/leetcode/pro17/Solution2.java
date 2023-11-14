package leetcode.pro17;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution2 {

    static Map<Character, String> map = new HashMap<>();
    static {
        int index = 2;
        int cnt = 0;
        for(int i = 0; i < 26; i++) {
            Character c = Integer.toString(index).charAt(0);
            String str = map.getOrDefault(c, "");
            str += ((char) ('a' + i));
            map.put(c, str);
            cnt++;
            if(index != 7 && index != 9) {
                if(cnt == 3) {
                    cnt = 0;
                    index++;
                }
            } else {
                if(cnt == 4) {
                    cnt = 0;
                    index++;
                }
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return new LinkedList<>();
        }
        List<String> ans = new LinkedList<>();
        dfs(ans, digits, 0, "");
        return ans;
    }

    public void dfs(List<String> ans, String digits, int index, String cur) {
        if(index == digits.length()) {
            ans.add(new String(cur));
            return;
        }
        Character c = digits.charAt(index);
        String str = map.get(c);
        for(int i = 0; i < str.length(); i++) {
            String next = cur + str.charAt(i);
            dfs(ans, digits, index + 1, next);
        }
    }

    public static void main(String[] argv) {
        for(Map.Entry<Character, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
