package pro79;

import java.util.Arrays;

public class Solution {
    public static boolean result = false;
    public boolean exist(char[][] board, String word) {
        result = false;
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(vis[i], false);
        }

        for(int i = 0; i < m; i++){
            for(int j=0; j < n; j++){
                if(board[i][j] == word.charAt(0)) {
                    vis[i][j] = true;
                    search(board, vis, i, j, m, n, 1, word);
                    vis[i][j] = false;
                }
            }
        }
        return result;
    }

    public void search(char[][] board, boolean[][] vis, int x, int y, int m, int n, int cur, String word) {
        if (cur >= word.length()) {
            result = true;
            return;
        }
        if(0 <= x - 1 && x -1 < m && vis[x-1][y] == false && board[x-1][y] == word.charAt(cur)) {
            vis[x-1][y] = true;
            search(board, vis, x-1, y, m, n, cur+1, word);
            vis[x-1][y] = false;
        }

        if(0 <= x + 1 && x +1 < m && vis[x+1][y] == false && board[x+1][y] == word.charAt(cur)) {
            vis[x+1][y] = true;
            search(board, vis, x+1, y, m, n, cur+1, word);
            vis[x+1][y] = false;
        }

        if(0 <= y-1 && y-1 < n && vis[x][y-1] == false && board[x][y-1] ==word.charAt(cur)) {
            vis[x][y-1] = true;
            search(board, vis, x, y-1, m, n, cur+1, word);
            vis[x][y-1] = false;
        }

        if(0 <= y+1 && y+1 < n && vis[x][y+1] == false && board[x][y+1] ==word.charAt(cur)) {
            vis[x][y+1] = true;
            search(board, vis, x, y+1, m, n, cur+1, word);
            vis[x][y+1] = false;
        }
    }

    public static void main(String[] argv){
        new Solution().exist(board, word);
    }

    public static char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    public static String word = "ABCB";

//    public static char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//    public static String word = "SEE";
}
