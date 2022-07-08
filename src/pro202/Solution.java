package pro202;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int cur = n;
        while(!set.contains(cur)) {
            set.add(cur);
            int next = 0;
            while(cur!=0) {
                int tmp = cur %10;
                next += tmp * tmp;
                cur /= 10;
            }
            if(next == 1) {
                return true;
            }
            cur = next;
        }
        return false;
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().isHappy(2));
    }
}
