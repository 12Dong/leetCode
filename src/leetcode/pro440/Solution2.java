package leetcode.pro440;

public class Solution2 {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        int cnt = 1;
        while(cnt < k) {
            int number = getPrefixNumber(cur, n);
            if(cnt + number <= k) {
                cnt += number;
                cur++;
            } else {
                cnt ++;
                cur *= 10;
            }
        }
        return cur;
    }

    public int getPrefixNumber(long prefix, int n) {
        int cnt = 0;
        long next = prefix + 1;
        while(prefix <= n) {
            cnt += Math.min(n + 1, next) - prefix;
            next = next * 10;
            prefix *= 10;
        }
        return cnt;
    }

    public static void main(String[] argv) {
        new Solution2().findKthNumber(681692778, 351251360);
    }
}
