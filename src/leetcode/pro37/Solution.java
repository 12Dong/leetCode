package leetcode.pro37;


public class Solution {
//    数字 1-9 在每一行只能出现一次。
//    数字 1-9 在每一列只能出现一次。
//    数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
    public void solveSudoku(char[][] board) {
        boolean[][] visRow = new boolean[board.length][10];
        boolean[][] visCol = new boolean[board[0].length][10];
        boolean[][][] vis = new boolean[3][3][10];

        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(Character.isDigit(board[i][j])) {
                    int num = board[i][j] - '0';
                    visRow[i][num] = true;
                    visCol[j][num] = true;
                    vis[i/3][j/3][num] = true;
                }
            }
        }
        dfs(board, n, m, visRow, visCol, vis, 0, 0);
    }

    public boolean dfs(char[][] board, int n, int m, boolean[][] visRow, boolean[][] visCol, boolean[][][] vis, int row, int col) {
        if(row == n) {
            return true;
        }

        System.out.println(row + " " + col);
        if(board[row][col] != '.') {
            if(dfs(board, n, m, visRow, visCol, vis, col + 1 == m ? row + 1 : row, col + 1 == m ? 0 : col + 1) == true) {
                return true;
            } else {
                return false;
            }
        }

        for(int i = 1; i <= 9; i++) {


            if(visRow[row][i] || visCol[col][i] || vis[row/3][col/3][i]) {

            } else {
                char c = Integer.toString(i).charAt(0);
                board[row][col] = c;
                visRow[row][i] = true;
                visCol[col][i] = true;
                vis[row/3][col/3][i] = true;

                if(dfs(board, n, m, visRow, visCol, vis, col + 1 == m ? row + 1 : row, col + 1 == m ? 0 : col + 1) == true) {
                    return true;
                }

                visRow[row][i] = false;
                visCol[col][i] = false;
                vis[row/3][col/3][i] = false;
                board[row][col] = '.';
            }
        }
        return false;
    }
    
    static char[][] board = new char[][] {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
    };
    
    public static void main(String[] argv) {
        new Solution().solveSudoku(board);
    }
}
