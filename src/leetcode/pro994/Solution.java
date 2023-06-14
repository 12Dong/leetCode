package leetcode.pro994;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static int[][] dir = new int[][]{{0,1}, {0,-1},{1,0},{-1,0}};
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Integer[]> queue = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new Integer[]{i,j});
                }
            }
        }
        int ans = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Integer[] pair = queue.poll();
                vis[pair[0]][pair[1]] = true;
                int x = pair[0];
                int y = pair[1];
                for(int j = 0; j < 4; j++) {
                    int nextX = x + dir[j][0];
                    int nextY = y + dir[j][1];
                    if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || vis[nextX][nextY] || grid[nextX][nextY] != 1) {
                        continue;
                    }
                    grid[nextX][nextY] = 2;
                    queue.add(new Integer[]{nextX, nextY});
                }
            }
            ans++;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return ans == -1 ? 0 : ans - 1;
    }
}
