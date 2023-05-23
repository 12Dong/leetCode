package leetcode.pro1438;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> treeSet = new TreeMap();
        int l = 0;
        int r = 1;
        int ans = 1;
        treeSet.put(nums[l], 1);
        while(r < nums.length) {
            int min = treeSet.firstKey();
            int max = treeSet.lastKey();
            if(Math.abs(nums[r] - min) <= limit && Math.abs(nums[r] - max) <= limit) {
                treeSet.put(nums[r], treeSet.getOrDefault(nums[r], 0) + 1);
                ans = Math.max(ans, r - l + 1);
                r++;
            } else {
                while(!treeSet.isEmpty() && (Math.abs(nums[r] - min) > limit || Math.abs(nums[r] - max) > limit)) {
//                    treeSet.remove(nums[l]);
                    int cnt = treeSet.get(nums[l]);
                    cnt--;
                    if(cnt == 0) {
                        treeSet.remove(nums[l]);
                    } else {
                        treeSet.put(nums[l], cnt);
                    }

                    l++;
                    if(treeSet.isEmpty()) {

                    } else {
                        min = treeSet.firstKey();
                        max = treeSet.lastKey();
                    }
                }
                treeSet.put(nums[r], treeSet.getOrDefault(nums[r], 0) + 1);
                ans = Math.max(ans, r - l + 1);
                r++;
            }
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution().longestSubarray(new int[]{4,2,2,2,4,4,2,2}, 0);
    }

}
