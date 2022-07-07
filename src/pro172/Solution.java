package pro172;

public class Solution  {
    public int trailingZeroes(int n) {
        int ans = 0;
        while(n>0) {
            int cur = n;
            while(cur % 10 == 0 || cur % 5 == 0) {
                if(cur % 10 == 0) {
                    cur /= 10;
                    ans++;
                } else {
                    cur /= 5;
                    ans++;
                }
            }
            n--;
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution().trailingZeroes(0);
    }
}
