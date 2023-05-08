package leetcode.pro48;

public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int cnt = (n + 1) / 2;
        for(int i = 0; i < n / 2; i++) {
            for(int j = 0; j < cnt ; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n -j -1][i];
                matrix[n -j -1][i] = matrix[n - i -1][n - j -1];
                matrix[n - i -1][n - j -1] = matrix[j][n -i -1];
                matrix[j][n -i -1] = tmp;
            }
        }

//        for(int i = 0; i < n;i ++) {
//            System.out.println(matrix[i]);
//        }
    }



}
