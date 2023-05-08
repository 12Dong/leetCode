package leetcode.pro189;

public class Solution {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = gcd(nums.length, k);
        for(int index = 0; index < count; index ++) {
            int next = (index + k) % nums.length;
            int lastVal = nums[index];
            while(next != index) {
                int tmp = lastVal;
                lastVal = nums[next];
                nums[next] = tmp;
                next = (next + k) % nums.length;
            }
            nums[index] = lastVal;
        }

    }

    public int gcd(int n, int m) {
       return m > 0 ?  gcd(m, n % m) : n;
    }
}
