package leetcode.pro239;

import java.util.Deque;
import java.util.LinkedList;

public class Solution4 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 降序队列 维护当前窗口最大值
        Deque<Integer> q = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        int tail = 0;
        for(int i = 0; i < k; i++) {
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.removeLast();
            }
            q.addLast(i);
        }
        ans[tail++] = nums[q.peekFirst()];
        for(int i = k; i < nums.length; i++) {
            if(q.peekFirst() <= i - k) {
                q.removeFirst();
            }
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.removeLast();
            }
            q.addLast(i);
            ans[tail++] = nums[q.peekFirst()];
        }
        return ans;
    }
}
