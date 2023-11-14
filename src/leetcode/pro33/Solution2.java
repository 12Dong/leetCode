package leetcode.pro33;

public class Solution2 {
    public static int search(int[] nums, int target) {
        if(nums.length == 0) {
            return -1;
        } else if(nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        if(nums[0] < nums[nums.length - 1]) {
            int l = 0;
            int r = nums.length - 1;
            while(l <= r) {
                int middle = (l + r) / 2;
                if(nums[middle] == target) {
                    return middle;
                } else if(nums[middle] < target) {
                    l = middle + 1;
                } else {
                    r = middle - 1;
                }
            }
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        int k = 0;
        while(l <= r) {
            int middle = (l + r) / 2;
            if(middle - 1 >= 0 && middle + 1 < nums.length) {
                if(nums[middle - 1] > nums[middle] && nums[middle + 1] > nums[middle]) {
                    k = middle;
                    break;
                } else if(nums[0] < nums[middle]) {
                    l = middle + 1;
                } else {
                    r = middle - 1;
                }
            } else if(middle - 1 < 0) {
                if(nums[middle + 1] > nums[middle]) {
                    k = middle;
                    break;
                } else {
                    l = middle + 1;
                }
            } else {
                if(nums[middle - 1] > nums[middle]) {
                    k = middle;
                    break;
                } else {
                    r = middle - 1;
                }
            }
        }
        if(target >= nums[0]) {
            // 左边找 target
            l = 0;
            r = k - 1;
            while(l <= r) {
                int middle = (l + r) / 2;
                if(nums[middle] == target) {
                    return middle;
                } else if(nums[middle] < target) {
                    l = middle + 1;
                } else {
                    r = middle - 1;
                }
            }
        } else {
            // 右边找 target
            l = k;
            r = nums.length - 1;
            while(l <= r) {
                int middle = (l + r) / 2;
                if(nums[middle] == target) {
                    return middle;
                } else if(nums[middle] < target) {
                    l = middle + 1;
                } else {
                    r = middle - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] argv) {
        System.out.println(search(new int[]{2,1}, 1));
    }
}
