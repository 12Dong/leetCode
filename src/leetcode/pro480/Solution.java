package leetcode.pro480;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public double[] medianSlidingWindow(int[] nums, int k) {

        PriorityQueue<Integer> small = new PriorityQueue<>((o1,o2)->Integer.compare(o2,o1));
        PriorityQueue<Integer> big = new PriorityQueue<>();
        for(int i = 0; i < k; i++) {
            big.add(nums[i]);
        }

        for(int i = 0; i < k/2; i++) {
            small.add(big.poll());
        }

        double[] ans = new double[nums.length - k + 1];
        int index = 0;
        if(k % 2 == 0) {
            ans[index++] = small.peek() * 1.0 / 2 + big.peek() * 1.0 / 2;
        } else {
            ans[index++] = (big.peek());
        }
        for(int i = k; i < nums.length; i++) {

            if(!small.remove(nums[i-k])) {
                big.remove(nums[i-k]);
            }

            if(big.isEmpty() || nums[i] >= big.peek()) {
                big.add(nums[i]);
                if(big.size() > small.size() + 1) {
                    small.add(big.poll());
                }
            } else {
                small.add(nums[i]);
                if(small.size() > big.size()) {
                    big.add(small.poll());
                }
            }

            if(k % 2 == 0) {
                ans[index++] = small.peek() * 1.0 / 2 + big.peek() * 1.0 / 2;
            } else {
                ans[index++] = (big.peek());
            }
        }
        return ans;
    }
}
