package leetcode.pro130;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    char x = 'X';

    char o = 'O';

    char w = 'W';
    public void solve(char[][] board) {
        for(int i = 0; i < board[0].length;i++) {
            if(board[0][i] == o) {
                bfsFill(board, o, w, 0, i);
            }

            if(board[board.length - 1][i] == o) {
                bfsFill(board, o, w, board.length - 1, i);
            }
        }

        for(int i = 0; i < board.length; i++) {
            if(board[i][0] == o) {
                bfsFill(board, o, w, i, 0);
            }

            if(board[i][board[0].length - 1] == o) {
                bfsFill(board, o, w, i, board[0].length - 1);
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == x || board[i][j] == w) {
                    continue;
                } else {
                    board[i][j] = x;
                }
            }
        }

        for(int i = 0; i < board[0].length;i++) {
            if(board[0][i] == w) {
                bfsFill(board, w, o, 0, i);
            }

            if(board[board.length - 1][i] == w) {
                bfsFill(board, w, o, board.length - 1, i);
            }
        }

        for(int i = 0; i < board.length; i++) {
            if(board[i][0] == w) {
                bfsFill(board, w, o, i, 0);
            }

            if(board[i][board[0].length - 1] == w) {
                bfsFill(board, w, o, i, board[0].length - 1);
            }
        }

    }

    static int[][] dir = new int[][]{{-1, 0}, {1,0}, {0, -1}, {0, 1}};

    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void bfsFill(char[][] board, char orgin, char fill, int x, int y) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        board[x][y] = fill;
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            vis[cur.x][cur.y] = true;
            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dir[i][0];
                int ny = cur.y + dir[i][1];
                if(nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length || vis[nx][ny] ||
                    board[nx][ny] != orgin) {
                    continue;
                } else {
                    board[nx][ny] = fill;
                    q.add(new Pair(nx, ny));
                }
            }
        }
        return;
    }
}
