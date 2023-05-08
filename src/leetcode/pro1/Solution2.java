package leetcode.pro1;

import java.util.Arrays;

public class Solution2 {

    public static class Pair implements Comparable {
        int location;
        int val;
        Pair(int location, int val) {
            this.val = val;
            this.location = location;
        }

        @Override
        public int compareTo(Object o) {
            return this.val - ((Pair)o).val;
        }
    }
    public int[] twoSum(int[] nums, int target) {
        Pair[] pairs = new Pair[nums.length];
        for(int i = 0; i < nums.length; i++){
            pairs[i] = new Pair(i, nums[i]);
        }
        Arrays.sort(pairs);
        for(int i = 0; i < nums.length; i++) {
            int val = target - pairs[i].val;
            int l = i + 1;
            int r = nums.length - 1;
            while(l <= r) {
                int middle = (l + r) / 2;
                if(pairs[middle].val == val) {

                    return new int[]{pairs[i].location, pairs[middle].location};
                } else if(pairs[middle].val > val) {
                    r = middle - 1;
                } else {
                    l = middle + 1;
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] argv) {
        new Solution2().twoSum(new int[]{-3, 4, 3, 90}, 0);
    }
}
