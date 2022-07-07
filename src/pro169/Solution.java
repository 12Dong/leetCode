package pro169;

public class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int ans = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if(ans == nums[i]) {
                count ++;
            } else {
                count --;
                if(count == 0) {
                    ans = nums[i];
                    count ++;
                }
            }
        }
        return ans;
    }
}
