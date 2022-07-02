package pro128;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap();
        for(Integer num : nums) {
            set.add(num);
            map.put(num, 1);
        }

        Integer ans = 0;
        for(Integer num : set) {
            if(map.get(num) != 1) {
                continue;
            }
            int cur = num;
            int length = 1;
            while(set.contains(cur + 1)) {
                int nextL = map.get(cur + 1);
                if(nextL == 1) {
                    map.put(cur + 1, length);
                    cur++;
                    length++;
                } else {
                    length+=nextL;
                    break;
                }
            }
            map.put(num, length);
            ans = Integer.max(ans, length);
        }
        return ans;
    }

    public static void main(String[] argv){
        new Solution().longestConsecutive(nums);
    }

//    public static int[] nums = new int[]{100,4,200,1,3,2};
    public static int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
}
