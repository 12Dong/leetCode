package pro56;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = Arrays.stream(intervals).sorted(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        }).collect(Collectors.toList());
        List<int[]> ans = new LinkedList<>();
        Integer l = null, r = null;
        for(int[] array : list) {
            if(l == null) {
                l = array[0];
                r = array[1];
                continue;
            }
            if(array[0] > r) {
                ans.add(new int[]{l, r});
                l = array[0];
                r = array[1];
                continue;
            } else {
                if(array[1] < r) {
                    continue;
                } else {
                    r = array[1];
                }
            }
        }
        ans.add(new int[]{l, r});
        int[][] ansArray = new int[ans.size()][2];
        int step = 0;
        for(int[] array : ans) {
            ansArray[step] = array;
            step++;
        }
        return ansArray;
    }

    public static void main(String[] argv) {
        new Solution().merge(new int[][]{new int[]{1,3},{2,6},{8,10},{15,18}});
    }
}
