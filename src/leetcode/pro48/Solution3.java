package leetcode.pro48;

public class Solution3 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n % 2 == 0) {
            for(int i = 0; i < n / 2; i++) {
                for(int j = 0; j < n / 2;j++) {
                    rr(matrix, i, j, n);
                }
            }
        } else {
            for(int i = 0; i < n / 2; i++) {
                for(int j = 0; j <= n / 2;j++) {
                    rr(matrix, i, j, n);
                }
            }
        }
        return;
    }

    public void rr(int[][] matrix, int i, int j, int n) {
        // 连续旋转 4 次
        int preV = matrix[i][j];
        int nextV;
        int x = i;
        int y = j;
        for(int k = 0; k < 3; k++) {
            int nextx = y;
            int nexty = Math.abs(n - 1 - x);
            nextV = matrix[nextx][nexty];
            matrix[nextx][nexty] = preV;
            preV = nextV;

            x = nextx;
            y = nexty;
        }
        matrix[i][j] = preV;
    }

    public static void main(String[] argv) {
        new Solution3().rotate(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}});
    }
}
