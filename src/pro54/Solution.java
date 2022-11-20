package pro54;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int curDir = 0;
        int x = 0;
        int y = 0;
        int total = n * m;
        while(total > 0) {
            vis[x][y] = true;
            ans.add(matrix[x][y]);
            total--;
            int nextX = x + dir[curDir][0];
            int nextY = y + dir[curDir][1];
            if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || vis[nextX][nextY]) {
                curDir = (curDir + 1) % 4;
                nextX = x + dir[curDir][0];
                nextY = y + dir[curDir][1];
            }
            x = nextX;
            y = nextY;
        }
        return ans;
    }
}
