package pro41;

import java.util.Arrays;

public class Solution3 {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int value = nums[i];
            int targetLocation = value - 1;
            if(targetLocation < 0 || targetLocation >= nums.length || value == i + 1 || value == nums[targetLocation]) {
                continue;
            } else {
                change(nums, targetLocation, value, i);
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == i + 1) {
                continue;
            } else {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void change(int[] nums, int targetLocation,int value, int srcLocation) {
        int tmpValue = nums[targetLocation];
        nums[targetLocation] = value;
        nums[srcLocation] = tmpValue;
        int tmpLocation = tmpValue - 1;
        if(tmpLocation < 0 || tmpLocation >= nums.length  || tmpValue == nums[tmpLocation]) {
            return;
        }
        if(tmpValue == srcLocation + 1) {
            return;
        } else{
            change(nums, tmpLocation, tmpValue, srcLocation);
        }
    }

    public static void main(String[] argv) {
        new Solution3().firstMissingPositive(new int[]{3, 4, -1, 1});
    }
}
