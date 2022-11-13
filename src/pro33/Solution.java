package pro33;

public class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        int k = -1;
        int middle;
        while(l < r) {
            middle = (l + r) /2;
            if(middle - 1 >= 0 && middle + 1 < nums.length && nums[middle] > nums[middle - 1] && nums[middle] > nums[middle + 1] ) {
                k = middle;
                break;
            }
            if(middle == 0 && middle + 1 < nums.length && nums[middle] > nums[middle+1]) {
                k = middle;
                break;
            }
            if(middle == nums.length - 1 && middle - 1 >=0 && nums[middle] > nums[middle-1]) {
                k = middle;
                break;
            }
            if(nums[middle] > nums[l]) {
                l = middle;
            } else {
                r = middle;
            }
        }
        if(k == - 1) {
            l = 0;
            r= nums.length - 1;
        }
        else if(nums[0] > target) {
            l = k + 1;
            r = nums.length - 1;
        } else if(nums[0] == target){
            return 0;
        } else {
            l = 0;
            r = k;
        }
        while(l <= r) {
            middle = (l + r) / 2;
            if(nums[middle] > target) {
                r = middle - 1;
            } else if(nums[middle] < target) {
                l = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] argv) {
        new Solution().search(new int[]{3, 1}, 1);
    }

}
