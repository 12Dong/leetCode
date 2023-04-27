package pro695;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[][] dir = new int[][]{{1,0}, {-1, 0}, {0,1}, {0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(vis[i][j]) {
                    continue;
                } else {
                    if(grid[i][j] == 0) {
                        continue;
                    } else {
                        vis[i][j] = true;
                        int cur = 0;
                        Queue<Point> q = new LinkedList<>();
                        q.add(new Point(i, j));
                        while(!q.isEmpty()) {
                            Point point = q.poll();
                            cur++;

                            for(int t = 0; t < 4; t++) {
                                int nextx = point.x + dir[t][0];
                                int nexty = point.y + dir[t][1];
                                if(nextx < 0 || nextx >= n || nexty < 0 || nexty >= m
                                        || vis[nextx][nexty] == true || grid[nextx][nexty] == 0) {
                                    continue;
                                } else {
                                    vis[nextx][nexty] = true;
                                    q.add(new Point(nextx, nexty));
                                }
                            }
                        }
                        ans = Math.max(ans, cur);
                    }
                }
            }
        }
        return ans;
    }

//    [
//    [1,1,0,0,0],
//    [1,1,0,0,0],
//    [0,0,0,1,1],
//    [0,0,0,1,1]]

    public static void main(String[] argv) {
        new Solution().maxAreaOfIsland(new int[][]{
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}
        });
    }
}
