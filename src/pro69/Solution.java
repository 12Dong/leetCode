package pro69;

public class Solution {
    public int mySqrt(int x) {
        long start = 1;
        long end = x;
        long middle = (start + end) / 2;
        long last = Integer.MIN_VALUE;
        while(start < end && last != middle) {
            if(middle * middle == x) {
                return (int) middle;
            } else if(middle * middle < x) {
                start = middle;
                last = middle;
                middle = (start + end) / 2;
            } else {
                end = middle;
                last = middle;
                middle = (start + end) / 2;
            }
        }
        return (int) middle;
    }

    public static void main(String[] argv){
        new Solution().mySqrt(2147395599);
    }
}
