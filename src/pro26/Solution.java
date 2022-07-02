package pro26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0;
        int r = 0;
        Integer last = null;
        while(r < nums.length) {
            if(last == null) {
                last = nums[r];
                r++;
                continue;
            }
            if(last == nums[r]) {
                r++;
            } else {
                nums[l] = last;
                l++;
                last = nums[r];
                r++;
            }
        }
        Long ll = Long.MAX_VALUE;
        if(last.equals(ll)) {
            r++;
        } else {
            nums[l] = last;
            l++;
            r++;
        }

        return l;
    }

    public static void main(String[] argv){
        new Solution().removeDuplicates(nums);
    }

    public static int[] nums = new int[]{1, 1};
}
