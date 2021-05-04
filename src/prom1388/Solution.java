package prom1388;

import java.util.Arrays;

public class Solution {
    public int maxSizeSlices(int[] slices) {
        int length = slices.length;
        int n = length / 3;
        int[][] dpFirst = new int[length][n + 1];
        dpFirst[0][1] = slices[0];
        dpFirst[1][1] = Math.max(dpFirst[0][1], slices[1]);
        int result = slices[0];
        for(int i = 2; i < length - 1; i++) {
            for(int j = 0; j <= n; j++){
                if(j == 0) {
                    dpFirst[i][j] = 0;
                } else if(j - 1 >= 0) {
                    dpFirst[i][j] = Math.max(dpFirst[i - 1][j], dpFirst[i - 2][j - 1] + slices[i]);
                }
                result = Math.max(result, dpFirst[i][j]);
            }
        }
//        for(int[] array : dpFirst){
//            System.out.println(Arrays.toString(array));
//        }

        int[][] dpLast = new int[length][n + 1];
        dpLast[1][0] = 0;
        dpLast[1][1] = slices[1];
        dpLast[2][0] = 0;
        dpLast[2][1] = Math.max(dpLast[1][1], slices[2]);
        for(int i = 3; i < length; i++){
            for(int j = 0; j <= n; j++){
                if(j == 0) {
                    dpLast[i][j] = 0;
                } else if(j - 1 >= 0) {
                    dpLast[i][j] = Math.max(dpLast[i - 1][j], dpLast[i - 2][j - 1] + slices[i]);
                }
                result = Math.max(result, dpLast[i][j]);
            }
        }
//        System.out.println("\n");
//        for(int[] array : dpLast){
//            System.out.println(Arrays.toString(array));
//        }
        return result;
    }

    public static void main(String[] argv){
        System.out.println(new Solution().maxSizeSlices(slices));
    }

//    static int[] slices = new int[]{1,2,3,4,5,6};
//    static int[] slices = new int[]{8,9,8,6,1,1};
//    static int[] slices = new int[]{4,1,2,5,8,3,1,9,7};
    static int[] slices = new int[]{3, 1, 2};
}
