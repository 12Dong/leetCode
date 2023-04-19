package pro560;

public class Solution2 {
    public int subarraySum(int[] nums, int k) {
        int[] prefix = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                prefix[0] = nums[0];
            } else {
                prefix[i] = prefix[i - 1] + nums[i];
            }
        }

        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                if(prefix[j] - prefix[i] + nums[i] == k) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
