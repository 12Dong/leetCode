package leetcode.pro378;

public class Solution2 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int l = matrix[0][0];
        int r = matrix[n - 1][m - 1];
        int anss = 0;
        while(l <= r) {
            int middle = l + (r - l) / 2;
            int cnt = countBinaryLess(matrix, middle);
            if(k == cnt + 1) {
                return ans;
            } else if(cnt + 1 < k) {
                anss = ans;
                l = middle + 1;
            } else {

                r = middle - 1;
            }
        }
        return anss;
    }

    static int ans = 0;

    public int countBinaryLess(int[][] matrix, int target) {
        ans = Integer.MAX_VALUE;
        int n = matrix.length;
        int m = matrix[0].length;
        int i = n - 1;
        int j = 0;
        int cnt = 0;
        while(i >= 0 && j < m) {
            if(matrix[i][j] < target) {
                cnt += (i + 1);
                j++;
            } else {
                ans = Math.min(ans, matrix[i][j]);
                i--;
            }
        }
        return cnt;
    }


    public static void main(String[] argv) {
        new Solution2().kthSmallest(new int[][]{{1,5,9}, {10,11,13}, {12,13,15}}, 8);
    }
}
