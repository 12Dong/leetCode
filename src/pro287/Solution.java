package pro287;

public class Solution {
    public int findDuplicate(int[] nums) {
        int slowIndex = 0;
        int fastIndex = 0;
        do {
            slowIndex = nums[slowIndex] % nums.length;
            fastIndex = nums[fastIndex] % nums.length;
            fastIndex = nums[fastIndex] % nums.length;
        } while(slowIndex != fastIndex);

        fastIndex = 0;
        while(slowIndex != fastIndex) {
            slowIndex = nums[slowIndex] % nums.length;
            fastIndex = nums[fastIndex] % nums.length;
        }
        return slowIndex;
    }


    public static void main(String[] argv) {
        new Solution().findDuplicate(new int[] {1,3,4,2,2});
    }
}
