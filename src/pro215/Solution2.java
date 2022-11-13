package pro215;

import pro3.Soultion;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue(k, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (Integer) o1 - (Integer) o2;
            }
        });

        for(int i = 0 ; i < nums.length; i ++ ) {
            if(queue.size() < k) {
                queue.add(nums[i]);
            } else {
                if(queue.peek() < nums[i]) {
                    queue.poll();
                    queue.add(nums[i]);
                }
            }
        }
        return queue.peek();
    }

    public static void main(String[] argv) {
        new Solution2().findKthLargest(new int[]{3, 2, 1, 5 , 6, 4}, 2);
    }
}
