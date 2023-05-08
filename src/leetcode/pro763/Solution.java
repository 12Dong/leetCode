package leetcode.pro763;

import java.util.*;

public class Solution {

    class Gap {
        char c;
        int start;
        int end;

        Gap (char c, int start, int end) {
            this.c = c;
            this.start = start;
            this.end = end;
        }
    }
    public List<Integer> partitionLabels(String s) {
        Map<Character, Gap> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                Gap gap = map.get(c);
                gap.end = i;
                map.put(c, gap);
            } else {
                Gap gap = new Gap(c, i, i);
                map.put(c, gap);
            }
        }

        List<Gap> list = new LinkedList<>(map.values());
        list.sort(new Comparator<Gap>() {
            @Override
            public int compare(Gap o1, Gap o2) {
                if(o1.start == o2.start) {
                    return o1.end - o2.start;
                } else {
                    return o1.start - o2.start;
                }
            }
        });
        List<Integer> points = new LinkedList<>();
        Gap g1 = list.get(0);
        int end = g1.end;
        for(int i = 1; i < list.size(); i++) {
            Gap cur = list.get(i);
            if(cur.start > end) {
                points.add(end);
                end = cur.end;
            } else {
                if(cur.end > end) {
                    end = cur.end;
                }
            }
        }
        points.add(end);
        List<Integer> ans = new LinkedList<>();
        int last = 0;
        for(int i = 0 ; i < points.size(); i++) {
            ans.add(points.get(i) - last + 1);
            last = points.get(i) + 1;
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution().partitionLabels("ababcbacadefegdehijhklij");
    }
}
