package leetcode.pro200;

public class Solution3 {

    public int numIslands(char[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '0' || grid[i][j] == '2') {
                    continue;
                } else {
                    ans++;
                    dfs(i, j, grid);
                }
            }
        }
        return ans;
    }

    int[][] dir = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};

    public void dfs(int cx, int cy, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < 4; i++) {
            int nx = cx + dir[i][0];
            int ny = cy + dir[i][1];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) {

            } else if(grid[nx][ny] == '0' || grid[nx][ny] == '2') {

            } else {
                grid[nx][ny] = '2';
                dfs(nx, ny, grid);
            }
        }
    }
}
