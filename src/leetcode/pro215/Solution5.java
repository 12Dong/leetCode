package leetcode.pro215;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Solution5 {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new LinkedList<>();
        for(int num : nums) {
            list.add(num);
        }
        return findKthLargest(list, k);
    }

    public int findKthLargest(List<Integer> nums, int k) {
        List<Integer> big = new LinkedList<>();
        List<Integer> equal = new LinkedList<>();
        List<Integer> small = new LinkedList<>();
        Random random = new Random();
        Integer base = nums.get(random.nextInt(nums.size()));
        for(int num : nums) {
            if(num > base ) {
                big.add(num);
            } else if(num < base) {
                small.add(num);
            } else {
                equal.add(num);
            }
        }
        if(big.size() >= k) {
            return findKthLargest(big, k);
        } else if(big.size() + equal.size() >= k) {
            return base;
        } else {
            return findKthLargest(small, k - big.size() - equal.size());
        }
    }

    public static void main(String[] argv) {
        new Solution5().findKthLargest(new int[]{3,2,1,5,6,4}, 2);
    }
}
