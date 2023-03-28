package pro448;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == i + 1) {
                continue;
            }
            int targetLocation = nums[i] - 1;
            if(targetLocation < 0 || targetLocation >= nums.length) {
                continue;
            } else {
                exchange(nums[i], targetLocation, nums);
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public void exchange(int curV, int targetL, int[] nums) {
        int replaceV = nums[targetL];
        if(replaceV == targetL + 1) {
            return;
        } else {
            nums[targetL] = curV;
            targetL = replaceV - 1;
            if(targetL < 0 || targetL >= nums.length) {
                return;
            } else {
                exchange(replaceV, targetL, nums);
            }
        }
    }
}
