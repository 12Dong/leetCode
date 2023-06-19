package leetcode.pro807;

public class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int x1 = Integer.MIN_VALUE;
                for(int x = i - 1; x >= 0; x--) {
                    if(grid[i][j] < grid[x][j]) {
                        x1 = x1 == Integer.MIN_VALUE ? grid[x][j] : Math.max(x1, grid[x][j]);
                        
                    }
                }
                int x2 = Integer.MIN_VALUE;
                for(int x = i + 1; x < n; x++) {
                    if(grid[i][j] < grid[x][j]) {
                        x2 = x2 == Integer.MIN_VALUE ? grid[x][j] : Math.max(x2, grid[x][j]);
                        
                    }
                }
                int y1 = Integer.MIN_VALUE;
                for(int y = j - 1;y >= 0; y --) {
                    if(grid[i][j] < grid[i][y]) {
                        y1 = y1 == Integer.MIN_VALUE ? grid[i][y] : Math.max(y1, grid[i][y]);
                        
                    }
                }
                int y2 = Integer.MIN_VALUE;
                for(int y = j + 1; y < m; y++) {
                    if(grid[i][j] < grid[i][y]) {
                        y2 = y2 == Integer.MIN_VALUE ? grid[i][y] : Math.max(y2, grid[i][y]);
                        
                    }
                }
               int x = Math.max(x1, x2);
               int y = Math.max(y1, y2);
               int addition = Math.min(x, y);
               if(addition != Integer.MIN_VALUE) {
                    ans += (addition - grid[i][j]);
               }
            }
        }
        return ans;
    }

//    [
//    [3,0,8,4],
//    [2,4,5,7],
//    [9,2,6,3],
//    [0,3,1,0]]
    public static void main(String[] argv) {
        System.out.println(new Solution().maxIncreaseKeepingSkyline(new int[][]{
                {3,0,8,4},
                {2,4,5,7},
                {9,2,6,3},
                {0,3,1,0}}));
    };

}

/*
gridNew = [ [8, 4, 8, 7],
            [7, 4, 7, 7],
            [9, 4, 8, 7],
            [3, 3, 3, 3] ]

 */
