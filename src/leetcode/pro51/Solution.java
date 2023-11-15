package leetcode.pro51;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] map = new char[n][n];
        boolean[][] allow = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(map[i], '.');
            Arrays.fill(allow[i],  true);
        }
        List<List<String>> ans = new LinkedList<>();
        dfs(ans, n, map, allow, 0, 0, 0);
        return ans;
    }

    public void dfs(List<List<String>> ans, int n, char[][] map, boolean[][] vis, int cur, int x, int y) {
        if(cur == 2) {
            int i = 1;
        }
        if(cur == n) {
            List<String> tmp = new LinkedList<>();
            for(char[] row : map) {
                tmp.add(new String(row));
            }
            ans.add(tmp);
            return;
        }

        if(x == n) {
            return;
        }

        if(vis[x][y] && map[x][y] == '.') {
            map[x][y] = 'Q';
            boolean[][] nextvis = new boolean[n][n];
            for(int tmp = 0; tmp < n; tmp++) {
                nextvis[tmp] = Arrays.copyOf(vis[tmp], n);
            }
            nextvis[x][y] = false;
            fillVis(nextvis, x, y, n);
            int nextx = x;
            int nexty = y + 1;
            if(nexty == n) {
                nexty = 0;
                nextx = nextx + 1;
            }
            dfs(ans, n, map, nextvis, cur + 1, nextx, nexty);

            map[x][y] = '.';
        }
        int nextx = x;
        int nexty = y + 1;
        if(nexty == n) {
            nexty = 0;
            nextx = nextx + 1;
        }
        dfs(ans, n, map, vis, cur, nextx, nexty);

    }

    public void fillVis(boolean[][] vis, int x, int y, int n) {
        for(int i = 0; i < n; i++) {
            vis[x][i] = false;
            vis[i][y] = false;
        }
        for(int i = 0; i < 4; i++) {
            int nextx = x + dir[i][0];
            int nexty = y + dir[i][1];
            while(true) {
                if(nextx < 0 || nextx >= n || nexty < 0 || nexty >= n) {
                    break;
                }
                vis[nextx][nexty] = false;
                nextx = nextx + dir[i][0];
                nexty = nexty + dir[i][1];
            }
        }
    }

    static int[][] dir = new int[][]{{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public static void main(String[] argv) {
        new Solution().solveNQueens(4);
    }
}
