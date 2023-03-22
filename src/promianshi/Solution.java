package promianshi;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

    public static List<Integer> solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> ans = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                ans.add(entry.getKey());
            }
        }

        return ans;
    }

    public static void main(String[] argv) {
        int[] nums = new int[]{1,1,2,2,3,5};
        List<Integer> ans = new Solution().solution(nums);
    }
}
