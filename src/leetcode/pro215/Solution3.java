package leetcode.pro215;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution3 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for(int i = 0; i < nums.length; i++) {
            if(priorityQueue.size() < k) {
                priorityQueue.add(nums[i]);
            } else {
                if(nums[i] < priorityQueue.peek()) {

                } else {
                    if(priorityQueue.size() == k) {
                        priorityQueue.remove();
                        priorityQueue.add(nums[i]);
                    } else {
                        priorityQueue.add(nums[i]);
                    }
                }
            }
        }
        return priorityQueue.peek();
    }

}
