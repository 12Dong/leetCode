package leetcode.pro528;

import java.util.Random;

public class Solution {

    static int[] prefix;
    static Random random = new Random();

    public Solution(int[] w) {
        prefix = new int[w.length + 1];
        for(int i = 0; i < w.length; i++) {
            prefix[i + 1] = prefix[i] + w[i];
        }
    }

    public static int pickIndex() {
        int rand = random.nextInt(prefix[prefix.length - 1]) + 1;
        int l = 1;
        int r = prefix.length - 1;
        while(l < r) {
            int middle = (l + r) / 2;
            if(rand <= prefix[middle] ) {
                r = middle;
            } else {
                l = middle + 1;
            }
        }
        return r - 1;
    }

    public static void main(String[] argv){
        new Solution(new int[]{1, 3}).pickIndex();
    }
}
