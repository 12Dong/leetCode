package leetcode.prom918;

public class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int length = A.length;
        int[] dpMax = new int[length];
        int max = A[0];
        dpMax[0] = max;
        for(int i = 1; i < length; i++){
            dpMax[i] = Math.max(dpMax[i -1] + A[i], A[i]);
            max = Math.max(dpMax[i], max);
        }
        int[] dpMin = new int[length];
        int min = A[0];
        dpMin[0] = min;
        int sum = min;
        for(int i = 1; i < length; i++){
            dpMin[i] = Math.min(dpMin[i -1] + A[i], A[i]);
            min = Math.min(dpMin[i], min);
            sum += A[i];
        }
        if(sum == min){
            return max;
        }
        return Math.max(max, sum - min);
    }

    public static void main(String[] argv){
        System.out.println(new Solution().maxSubarraySumCircular(A));
    }

//    static int[] A = new int[]{1,-2,3,-2};
//    static int[] A = new int[]{5, -3, 5};
//    static int[] A = new int[]{3, -1, 2, -1};
    static int[] A = new int[]{-2, -3, -1};
}
