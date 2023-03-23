package nc75;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int[] FindNumsAppearOnce (int[] array) {
        int xor = array[0];
        for(int i = 1; i < array.length; i++) {
            xor = xor ^ array[i];
        }
        int cnt = 1;
        while(xor !=0) {
            int i = xor % 2;
            if(i == 0) {
                cnt++;
                xor = xor / 2;
            } else {
                break;
            }
        }
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        for(int i = 0; i < array.length; i++) {
            int v = 0;
            int t = array[i];
            for(int tmp = 0; tmp < cnt; tmp++) {
                v = t % 2;
                t = t / 2;
            }
            if(v == 0) {
                list1.add(array[i]);
            } else {
                list2.add(array[i]);
            }
        }
        int ans1 = 0;
        for(Integer num : list1) {
            ans1 = ans1 ^ num;
        }
        int ans2 = 0;
        for(Integer num : list2) {
            ans2 = ans2 ^ num;
        }
        int[] ans = ans1 > ans2 ? new int[]{ans2, ans1} : new int[]{ans1,ans2};
        return ans;
    }

    public static void main(String[] argv) {
        int[] nums = new int[]{1, 1, 2, 3};
        new Solution().FindNumsAppearOnce(nums);
    }
}
