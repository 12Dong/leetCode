package leetcode.pro200;

public class Solution {
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{ 0, 0,-1, 1};
    public int numIslands(char[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n;i++){
            for(int j = 0; j < m;j++){
                if(grid[i][j] == '1') {
                    grid[i][j] = '0';
                    dfs(grid, i, j, n, m);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] grid, int curX, int curY, int n, int m) {
        for(int i = 0; i < 4; i++) {
            int nx = curX + dx[i];
            int ny = curY + dy[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m || grid[nx][ny] == '0') {
                continue;
            }
            grid[nx][ny] = '0';
            dfs(grid, nx, ny, n, m);
        }
    }
}
