package pro556;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    // 54231 -> 54312
    // 543193 - > 543319
    // 54213 ->

    // 53241 -> 53412
    public int nextGreaterElement(int n) {
        Integer[] nums = new Integer[33];
        int index = 0;
        while(n != 0) {
            nums[index] = n % 10;
            index++;
            n /= 10;
        }
        int l = -2;
        for(int i = 1; i < index; i++) {
            if(nums[i] >= nums[i - 1]) {
                continue;
            } else {
                l = i;
                break;
            }
        }

        if(l == -2) {
            return -1;
        }

        int t = l - 1;
        for(int i = 0; i < l; i ++) {
            if(nums[i] > nums[l] && nums[i] < nums[t]) {
                t = i;
            }
        }
        int tmp = nums[l];
        nums[l] = nums[t];
        nums[t] = tmp;
        Arrays.sort(nums, 0, l,
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                });
        Long ans = 0L;
        int time = 1;
        for(int i = 0; i < index; i++) {
            ans += ((long)time * nums[i]);
            time *= 10;
        }
        if(ans > Integer.MAX_VALUE) {
            return -1;
        }
        return ans.intValue();
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().nextGreaterElement(1999999999));
    }
}
