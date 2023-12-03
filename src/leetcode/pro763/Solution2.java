package leetcode.pro763;

import java.util.*;

public class Solution2 {

    class Part{
        Character c;
        int start;
        int end;
    }
    public List<Integer> partitionLabels(String s) {
        Map<Character, Part> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(map.containsKey(c)) {
                Part part = map.get(c);
                part.start = Math.min(part.start, i);
                part.end = Math.max(part.end, i);
                map.put(c, part);
            } else {
                Part part = new Part();
                part.c = c;
                part.start = i;
                part.end = i;
                map.put(c, part);
            }
        }
        List<Part> parts = new LinkedList<>();
        for(Map.Entry<Character, Part> entry : map.entrySet()) {
            parts.add(entry.getValue());
        }
        parts.sort(new Comparator<Part>() {
            @Override
            public int compare(Part o1, Part o2) {
                if(o1.start != o2.start) {
                    return o1.start - o2.start;
                } else {
                    return o1.end - o2.end;
                }
            }
        });

        int l = parts.get(0).start;
        int r = parts.get(0).end;
        List<Integer> ans = new LinkedList<>();
        for(int i = 1; i < parts.size(); i++) {
            Part part = parts.get(i);
            if(part.start < r) {
                r = Math.max(part.end, r);
            } else {
                ans.add(r - l + 1);
                l = part.start;
                r = part.end;
            }
        }
        ans.add(r - l + 1);
        return ans;
    }

    public static void main(String[] argv) {
        new Solution2().partitionLabels("ababcbacadefegdehijhklij");
    }
}
