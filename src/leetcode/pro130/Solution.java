package leetcode.pro130;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static int[] dx = new int[]{-1, 1,  0, 0};
    public static int[] dy = new int[]{ 0, 0, -1, 1};

    public static class Pair {
        int x;
        int y;

        Pair( int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(board[i][0] == 'O') {
                queue.add(new Pair(i, 0));
                board[i][0] = 'A';
            }
            if(board[i][m-1] == 'O') {
                queue.add(new Pair(i, m-1));
                board[i][m-1] = 'A';
            }
        }

        for(int i = 0; i < m; i++) {
            if(board[0][i] == 'O') {
                queue.add(new Pair(0, i));
                board[0][i] = 'A';
            }
            if(board[n-1][i] == 'O') {
                queue.add(new Pair(n-1, i));
                board[n-1][i] = 'A';
            }
        }

        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 'O') {
                    queue.add(new Pair(nx, ny));
                }
            }
            board[pair.x][pair.y] = 'A';
        }

        for(int i = 0; i < n;i++){
            for(int j = 0; j <m; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        for(int i = 0; i < n;i++){
            for(int j = 0; j <m; j++) {
                if(board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
