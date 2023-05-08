package leetcode.pro79;

public class Solution2 {

    public static boolean sign = false;
    public static Integer n;
    public static Integer m;
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0 ; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == word.charAt(0)) {
                    sign = false;
                    dfs(board, i,j, vis, word, 0);
                    if(sign) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void dfs(char[][] board, int cx, int cy, boolean[][] vis, String word, int cur) {
        if(cur == word.length()) {
            sign = true;
            return;
        }

        if(board[cx][cy] != word.charAt(cur)) {
            return;
        }

        if(cur + 1 == word.length()) {
            sign = true;
            return;
        }

        vis[cx][cy] = true;
        for(int i = 0; i < 4; i++) {
            int nx = cx + dir[i][0];
            int ny = cy + dir[i][1];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m || vis[nx][ny]) {
                continue;
            }
            dfs(board, nx, ny, vis, word, cur + 1);
        }
        vis[cx][cy] = false;
    }
}
