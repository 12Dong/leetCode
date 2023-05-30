package leetcode.pro915;

public class Solution {

//    输入：nums = [1,1,1,0,6,12]
//    输出：4
//    解释：left = [1,1,1,0]，right = [6,12]

//    输入：nums = [5,0,3,8,6]
//    输出：3
//    解释：left = [5,0,3]，right = [8,6]
    public int   partitionDisjoint(int[] nums) {
        int[] maxs = new int[nums.length];
        int[] mins = new int[nums.length];
        int max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            maxs[i] = max;
        }
        int min = nums[nums.length - 1];
        for(int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(nums[i], min);
            mins[i] = min;
        }
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i != nums.length - 1) {
                if(maxs[i] <= mins[i + 1]) {
                    return i + 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().partitionDisjoint(new int[] {1, 1,1, 0,6, 12}));
    }
}
