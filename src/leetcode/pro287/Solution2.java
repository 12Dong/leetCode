package leetcode.pro287;

public class Solution2 {
    public int findDuplicate(int[] nums) {
        // 等价于 寻找循环节 前的一个节点
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
        } while(slow != fast);

        fast = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
