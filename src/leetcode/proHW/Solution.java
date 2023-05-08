//package leetcode.proHW;
//
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Set;
//
//public class Solution {
//
//    /**
//     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
//     * 注意：答案中不可以包含重复的三元组。
//     * 示例 1：
//     * 输入：nums = [-1,0,1,2,-1,-4]
//     * 输出：[[-1,-1,2],[-1,0,1]]
//     * 示例 2：
//     * 输入：nums = []
//     * 输出：[]
//     * 示例 3：
//     * 输入：nums = [0]
//     * 输出：[]
//     * 提示：
//     * 0 <= nums.length <= 3000
//     * -10的五次方 <= nums[i] <= 10的五次方
//     * @param nums
//     * @return
//     */
//
//    public static List<List<Integer>> solution(int[] nums) {
//        Arrays.sort(nums);
//        Set<List<Integer>> ans = new LinkedLis();
//        for(int i = 0; i < nums.length; i++) {
//            if(i != 0 && nums[i] == nums[i- 1]) {
//                continue;
//            }
//            int target =  - nums[i];
//            int start = i + 1;
//            int end = nums.length - 1;
//            while(start < end) {
//                int mid = (start + end) / 2;
//                int sum = nums[start] + nums[end];
//                if(sum == target) {
//                    List<Integer> cur = Arrays.asList(nums[i], nums[start], nums[end]);
//                    ans.add(cur);
////                    break;
//                    start++;
//                    end--;
//                } else if(sum < target) {
//                    start = start == mid ? mid + 1 : mid;
//
//                } else {
//                    end = end == mid ? mid - 1 : mid;
//                }
//            }
//        }
//        return ans;
//    }
//
//    public static void main(String[] argv) {
//        int[] nums = new int[]{-1,0,1,2,-1,-4};
////        solution(nums);
////        nums = new int[]{};
////        solution(nums);
////        nums = new int[]{0};
////        solution(nums);
////        nums = new int[]{-1, -1, 0, 1};
////        solution(nums);
//        nums = new int[]{-4, 2,2 ,3,1};
//        solution(nums);
//    }
//}
