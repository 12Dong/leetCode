package leetcode.pro440;

public class Solution {

    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;
        while (k > 0) {
            int steps = getSteps(curr, n);
            if (steps <= k) {
                k -= steps;
                curr++;
            } else {
                curr = curr * 10;
                k--;
            }
        }
        return curr;
    }

    public int findPrefix(int prefix, int n) {
        int count = 0;
        int next = prefix + 1;
        while(prefix <= n) {
            count += (Math.min(n + 1, next) - prefix);
            prefix *= 10;
            next *= 10;
        }
        return count;
    }

    public int getSteps(int curr, long n) {
        int steps = 0;
        long first = curr;
        long last = curr;
        while (first <= n) {
            steps += Math.min(last, n) - first + 1;
            first = first * 10;
            last = last * 10 + 9;
        }
        return steps;
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().findKthNumber(681692778, 351251360));
    }
}
