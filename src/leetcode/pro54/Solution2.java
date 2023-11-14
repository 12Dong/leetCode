package leetcode.pro54;

import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    static int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public List<Integer> spiralOrder(int[][] matrix) {
        int down = matrix.length;
        int up = 0;
        int l = 0;
        int r = matrix[0].length;
        int cnt = 0;
        int total = down * r;
        List<Integer> ans = new LinkedList<>();
        int curx = 0;
        int cury = 0;
        int index = 0;
        while(cnt < total) {
            ans.add(matrix[curx][cury]);
            int nextx = curx + dir[index][0];
            int nexty = cury + dir[index][1];
            // 越界
            if(nextx < up || nextx >= down || nexty < l || nexty >= r) {
                index = (index + 1) % 4;
                if(nexty >= r) {
                    up++;
                } else if(nextx >= down) {
                    r--;
                } else if(nexty < l) {
                    down--;
                } else if(nextx < up) {
                    l++;
                }
                nextx = curx + dir[index][0];
                nexty = cury + dir[index][1];
            }
            curx = nextx;
            cury = nexty;
            cnt++;
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution2().spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}
