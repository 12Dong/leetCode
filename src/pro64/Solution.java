package pro64;

public class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] cur = new int[m];
        int[] next = new int[m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0) {
                    if(j == 0) {
                        next[0] = grid[i][0];
                    } else {
                        next[j] = next[j - 1] + grid[i][j];
                    }
                } else {
                    if(j == 0) {
                        next[0] = cur[0] + grid[i][j];
                    } else {
                        next[j] = Math.min(cur[j], next[j - 1]) + grid[i][j];
                    }
                }
                cur = next;
            }
        }
        return cur[m - 1];
    }
}
