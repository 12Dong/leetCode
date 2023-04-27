package pro153;

public class Solution {
//    [0,1,2,4,5,6,7]
//    7,0,1,2,4,5,6
//    6 7 0,1,2,4,5
//    5 6 7 5 0,1,2,4
//    4 5 6 7 0,1,2
    public int findMin(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums[0] < nums[nums.length -1]) {
            return nums[0];
        }

        if(nums[nums.length - 1] < nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }
        int l = 0;
        int r = nums.length -1;
        while(l < r) {
            int middle = (l + r) / 2;
            if(nums[middle] < nums[middle -1] && nums[middle] < nums[middle + 1]) {
                return nums[middle];
            } else if(nums[middle] > nums[0]){
                l = middle;
            } else {
                r = middle;
            }
        }
        return 0;
    }

    public static void main(String[] argv) {
        new Solution().findMin(new int[]{4,5,6,7,0,1,2});
    }
}
