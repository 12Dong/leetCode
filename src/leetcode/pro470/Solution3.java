package leetcode.pro470;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Solution3 {
    public int rand10() {
        while(true) {
            int high = 7 * (rand7() - 1);
            int low = (rand7() - 1);
            if(high + low + 1 > 10) {
                continue;
            } else {
                return high + low + 1;
            }
        }
    }

    public int rand7() {
        return 1;
    }
}
