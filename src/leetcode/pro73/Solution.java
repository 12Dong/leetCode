package leetcode.pro73;

public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean row0_flag = false;
        boolean row1_flag = false;
        boolean col0_flag = false;
        boolean col1_flag = false;
        for(int i = 0; i < matrix[0].length; i++) {
            if(matrix[0][i] == 0) {
                row0_flag = true;
            }
        }
        for(int i = 0; i < matrix[matrix.length - 1].length; i++) {
            if(matrix[matrix.length - 1][i] == 0) {
                row1_flag = true;
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                col0_flag = true;
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][matrix[0].length - 1] == 0) {
                col1_flag = true;
            }
        }
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < m - 1; i++) {
            if(matrix[0][i] == 0) {
                for(int j = 1; j < n; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        for(int i = 1; i < n - 1; i++) {
            if(matrix[i][0] == 0) {
                for(int j = 1; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(row0_flag) {
            for(int i = 0; i < m; i++) {
                matrix[0][i] = 0;
            }
        }
        if(row1_flag) {
            for(int i = 0; i < m; i++) {
                matrix[n - 1][i] = 0;
            }
        }
        if(col0_flag) {
            for(int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
        if(col1_flag) {
            for(int i = 0; i < n; i++) {
                matrix[i][m - 1] = 0;
            }
        }
    }

    public static void main(String[] argv) {
        new Solution().setZeroes(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
    }
}
