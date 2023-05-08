package pro134;

public class Solution2 {

//    [1,2,3,4,5], cost =
//    [3,4,5,1,2]
//    [-2, -2, -2, 3, 3]
//    [2,3,4], cost =
//    [3,4,3]
//    [-1, -1, 1]

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] rest = new int[gas.length];
        int all = 0;
        int cur = 0;
        int ans = -1;
        for(int i = 0; i < gas.length; i++) {
            rest[i] = gas[i] - cost[i];
            all += rest[i];
            cur += rest[i];
            if(cur < 0) {
                cur = 0;
                ans = -1;
            } else {
                if(ans == -1) {
                    ans = i;
                }
            }
        }
        if(all < 0 || ans == -1) {
            return -1;
        } else {
            return ans;
        }
    }
}
