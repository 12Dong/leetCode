package swardoffer.pro61;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public boolean isStraight(int[] nums) {
        int start = 20;
        Map<Integer, Integer> cntMap = new TreeMap<>();
        for(int num : nums) {
            if(num >= 1) {
                start = Math.min(start, num);
            }
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }

        if(start == 20) {
            return cntMap.get(0) == 5;
        } else {
            for(int i = start; i <= start + 4; i++) {
                if(cntMap.containsKey(i)) {

                } else {
                    if(cntMap.containsKey(0) && cntMap.get(0) > 0) {
                        cntMap.put(0, cntMap.get(0) - 1);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
