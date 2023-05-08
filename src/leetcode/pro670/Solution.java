package leetcode.pro670;

import java.util.Arrays;

public class Solution {

    class Pair {
        int val;
        int location;
    }
    public int maximumSwap(int num) {
        int source = num;
        int[] nums = new int[9];
        int r = 0;
        while(num != 0) {
            nums[r] = num % 10;
            num /= 10;
            r++;
        }
        int[] maxs = Arrays.copyOfRange(nums, 0, r);
        Arrays.sort(maxs, 0, r);
        int location = -1;
        for(int i = r - 1; i >= 0; i--) {
            if(nums[i] == maxs[i]) {
                continue;
            } else {
                location = i;
                break;
            }
        }
        if(location == -1) {
            return source;
        }
        for(int i = 0; i < r; i++) {
            if(nums[i] == maxs[location]) {
                int tmp = nums[location];
                nums[location] = maxs[location];
                nums[i] = tmp;
                break;
            }
        }
        int ans = 0;
        int cur = 1;
        for(int i = 0; i < r; i++) {
            ans += cur * nums[i];
            cur *= 10;
        }
        return ans;
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().maximumSwap(115));
        System.out.println(new Solution().maximumSwap(1993));
    }
}
