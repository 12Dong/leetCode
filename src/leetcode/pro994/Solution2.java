package leetcode.pro994;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    static int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    class Pair {
        int x;
        int y;
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int cnt = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    cnt++;
                } else if(grid[i][j] == 2) {
                    grid[i][j] = 3;
                    Pair p = new Pair();
                    p.x = i;
                    p.y = j;
                    q.add(p);
                }
            }
        }
        if(cnt == 0) {
            return 0;
        }
        int ans = -1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                Pair p = q.poll();
                for(int i = 0; i < 4; i++) {
                    int nextx = p.x + dir[i][0];
                    int nexty = p.y + dir[i][1];
                    if(nextx < 0 || nextx >= n || nexty < 0 || nexty >= m) {
                        continue;
                    }
                    if(grid[nextx][nexty] == 1) {
                        cnt--;
                        grid[nextx][nexty] = 3;
                        Pair next = new Pair();
                        next.x = nextx;
                        next.y = nexty;
                        q.add(next);
                    }
                }
                size--;
            }
            ans++;
        }
        return cnt > 0 ? -1 : ans;
    }
}
