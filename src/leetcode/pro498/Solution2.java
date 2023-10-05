package leetcode.pro498;

public class Solution2 {
    int[][] dir = new int[][]{{-1, 1}, {1, -1}};
    public int[] findDiagonalOrder(int[][] mat) {
        int index = 0;
        int n = mat.length;
        int m = mat[0].length;
        int[] ans = new int[n * m];
        int x = 0;
        int y = 0;
        int d = 0;
        while(index < ans.length) {
            ans[index] = mat[x][y];
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];

            // 越界了 进阶到下一层
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                if(d == 0) {
                    // 先右后下
                    nx = x;
                    ny = y + 1;
                    if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        nx = x + 1;
                        ny = y;
                    }
                } else {
                    // 先下后右
                    nx = x + 1;
                    ny = y;
                    if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        nx = x;
                        ny = y + 1;
                    }
                }
                d = (d + 1) % 2;
            }
            x = nx;
            y = ny;
            index++;
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution2().findDiagonalOrder(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}});
    }
}
