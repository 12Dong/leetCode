package leetcode.pro48;

public class Solution4 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n % 2 == 1) {
            for(int i = 0; i <= n / 2; i++) {
                for(int j = 0; j < n / 2; j++) {
                    rotate(matrix, i, j, matrix[i][j], 0);
                }
            }
        } else {
            for(int i = 0; i < n / 2; i++) {
                for(int j = 0; j < n / 2; j++) {
                    rotate(matrix, i, j, matrix[i][j], 0);
                }
            }
        }
    }

    public void rotate(int[][] matrix, int x, int y, int value, int cnt) {
        if(cnt == 4) {
            return;
        }
        int n = matrix.length - 1;
        int nextx = y;
        int nexty = n - x;
        int nextv = matrix[nextx][nexty];
        matrix[nextx][nexty] = value;

        rotate(matrix, nextx, nexty, nextv, cnt + 1);
    }
}
