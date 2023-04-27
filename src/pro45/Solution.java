package pro45;

import java.util.Arrays;

public class Solution {

//    输入
//[2,3,1,1,4]
//[2,3,0,1,4]
//    [1,2,1,1,1]
//    [7,0,9,6,9,6,1,7,9,0,1,2,9,0,3]



    public int jump(int[] nums) {
        int step = 0;
        int max = 0;
        int end = 0;
        if(nums.length == 1) {
            return 0;
        }
        for(int i = 0; i < nums.length - 1; i++) {
            if(i + nums[i] > max) {
                max = Math.max(max, i + nums[i]);
            }
            if(i == end) {
                end = max;
                step++;
            }
        }
        return step;
    }
}
