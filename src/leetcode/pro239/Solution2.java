package leetcode.pro239;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
//        最大数字的位置
        Deque<Integer> queue = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length; i++) {
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if(queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }

            if(i+1 >=k) {
                ans[i+1-k] = nums[queue.peekFirst()];
            }
        }
        return ans;
    }

}
