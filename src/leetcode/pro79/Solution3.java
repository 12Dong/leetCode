package leetcode.pro79;

public class Solution3 {
    public boolean exist(char[][] board, String word) {
        sign = false;
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                vis[i][j] = true;
                dfs(board, vis, i, j, word, 0);
                vis[i][j] = false;
            }
        }
        return sign;
    }

    static boolean sign = false;

    static int[][] dir = new int[][]{{0,1}, {0, -1}, {1,0}, {-1,0}};

    public void dfs(char[][] board, boolean[][] vis, int x, int y, String word, int index) {
        if(sign) {
            return;
        }

        int n = board.length;
        int m = board[0].length;

        if(board[x][y] != word.charAt(index)) {
            return;
        }

        if(index == word.length() - 1) {
            sign = true;
            return;
        }
        for(int i = 0; i < 4; i++) {
            int nextx = x + dir[i][0];
            int nexty = y + dir[i][1];
            if(nextx < 0 || nextx >= n || nexty < 0 || nexty >= m) {
                continue;
            }
            if(vis[nextx][nexty]) {
                continue;
            }

            vis[nextx][nexty] = true;
            dfs(board, vis, nextx, nexty, word, index + 1);
            vis[nextx][nexty] = false;
        }


    }
}
