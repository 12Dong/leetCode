package leetcode.pro470;
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */

public class Solution2 {

    public int rand10() {
        int a = rand7();
        int b = rand7();
        int value = (a - 1) * 7 + (b);
        while(value > 10) {
            a = rand7();
            b = rand7();
            value = (a - 1) * 7 + (b);;
        }
        return value;
    }

    public int rand7() {
        return 1;
    }

}
