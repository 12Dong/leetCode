package leetcode.pro200;

public class Solution2 {

    public static int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numIslands(char[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    ans++;
                    dfs(i, j, n, m, grid);
                }
            }
        }
        return ans;
    }

    public void dfs(int x, int y, int n, int m, char[][] grid) {
        grid[x][y] = '2';
        for(int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == '1') {
                dfs(nx, ny, n, m, grid);
            }
        }
    }
}
