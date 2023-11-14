package leetcode.pro239;

import java.util.Deque;
import java.util.LinkedList;

public class Solution3 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList();
        int[] ans = new int[nums.length - k + 1];
        int cur = 0;
        for(int i = 0; i < k; i++) {
            if(q.isEmpty()) {
                q.addLast(i);
            } else {
                while(!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                    q.removeLast();
                }
                q.addLast(i);
            }
        }
        ans[cur] = nums[q.peekFirst()];
        cur++;
        for(int i = k; i < nums.length; i++) {
            // 检查 q 头 是否 越界 和 k 和 i 比
            while(!q.isEmpty() && q.peekFirst() < (i - k + 1)) {
                q.removeFirst();
            }
            // 添加新的数 到 q 中
            if(q.isEmpty()) {
                q.addLast(i);
            } else {
                while(!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                    q.removeLast();
                }
                q.addLast(i);
            }
            // 添加答案
            ans[cur] = nums[q.peekFirst()];
            cur++;
        }
        return ans;
    }
}
