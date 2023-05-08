package leetcode.pro134;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] rest = new int[gas.length];
        int n = gas.length;
        int mostCost = Integer.MAX_VALUE;
        int total = 0;
        int start = 0;
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                rest[i] = gas[i] - cost[i];
            } else {
                rest[i] = rest[i-1] + gas[i] - cost[i];
            }
            if(rest[i] < mostCost) {
                mostCost = rest[i];
                start = i;
            }

            total += gas[i] - cost[i];
        }
        if(total < 0) {
            return -1;
        } else {
            return (start + 1)%n;
        }
    }
}
