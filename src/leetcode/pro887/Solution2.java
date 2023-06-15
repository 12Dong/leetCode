package leetcode.pro887;

import leetcode.pro1049.Solution;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    static Map<Integer, Integer>  cntMap = new HashMap<>();

    public int superEggDrop(int k, int n) {
        if(k == 1) {
            return n;
        }
        if(n == 0) {
            return 0;
        }
        if(cntMap.containsKey(n * 100 + k)) {
            return cntMap.get(n * 100 + k);
        }
        int lo = 1;
        int hi = n;
        while(lo + 1 < hi) {
            int middle = lo + ( (hi - lo) >> 1);
            int t1 = superEggDrop(k - 1, middle - 1);
            int t2 = superEggDrop(k, n - middle);
            if(t1 < t2) {
                lo = middle;
            } else if(t1 > t2) {
                hi = middle;
            } else {
                lo = hi = middle;
            }
        }
        int ans = 1 + Math.min(Math.max(superEggDrop(k - 1, lo - 1), superEggDrop(k, n - lo)),
                Math.max(superEggDrop(k - 1, hi - 1), superEggDrop(k, n - hi)));
        cntMap.put(100 * n + k, ans);
        return ans;
    }

    public static void main(String[] argv) {
        System.out.println(new Solution2().superEggDrop(2,6));
    }
}
