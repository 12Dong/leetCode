package leetcode.pro887;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution3 {

    static Map<Integer, Integer> cntMap = new HashMap<>();

    public int superEggDrop(int k, int n) {

        Queue<Integer> q = new LinkedList<>();
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
            int middle = lo + ((hi - lo) >> 1);
            int broken = superEggDrop(k - 1, middle - 1);
            int notBroken = superEggDrop(k, n - middle);
            if(broken < notBroken) {
                lo = middle;
            } else if(broken > notBroken) {
                hi = middle;
            } else {
                lo = hi = middle;
            }
        }
        int t1 = Math.max(superEggDrop(k - 1, lo - 1), superEggDrop(k, n - lo));
        int t2 = Math.max(superEggDrop(k - 1, hi - 1), superEggDrop(k, n - hi));
        int ans = 1 + Math.min(t1, t2);
        cntMap.put(n * 100 + k, ans);
        return ans;
    }
}
