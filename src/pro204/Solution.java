package pro204;

import java.util.Arrays;

public class Solution {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[5000005];
        int ans = 0;
        Arrays.fill(primes, false);
        for(int i = 2; i <n ;i++) {
            if(primes[i] == false) {
                ans++;
                int multi = 2;
                while(i * multi <= n) {
                    primes[i * multi] = true;
                    multi++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution().countPrimes(10);
    }
}
