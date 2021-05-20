package pro136;

public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int num : nums){
            result = result ^ num;
        }
        return result;
    }

    public static void main(String[] argv){
        System.out.println(new Solution().singleNumber(nums));
    }

//    static int[] nums = new int[]{2, 2, 1};
    static int[] nums = new int[]{4, 1, 2, 1, 2};
}
