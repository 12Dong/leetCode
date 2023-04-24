package pro498;

public class Solution {
//    输入：mat = [[1,2,3],
//                [4,5,6],
//                [7,8,9]]
//    (0, 0) ->
//    (-1, 1) ->
//    (0, 1) -> (1,0) ->
//    (2, -1) ->
//    (2,0) -> (1,1) -> (0,2)
//    (-1, 3) ->
//    -> ( 1,2) -> (2,1) ->
//    (3,0)
//    (2,2)
//输出：[1,2,4,7,5,3,6,8,9]

//    1 2
//    3 4

    public static int[][] move = new int[][]{{-1, 1}, {1, -1}};

    public int[] findDiagonalOrder(int[][] mat) {
        int curx = 0;
        int cury = 0;
        int count = 0;
        int limit = mat.length * mat[0].length;
        int[] ans = new int[limit];
        boolean sign = false;
        int index = 0;
        int curV = 0;
        while(count < limit) {
            ans[count++] = mat[curx][cury];
            curx += move[index][0];
            cury += move[index][1];
            if(curx < 0 || curx >= mat.length || cury < 0 || cury >= mat[0].length) {
                curV ++;
                // 本次对角线完成 开始下一次对角线
                if(sign) {
                    // 本次 x 增大 下次 x 减小
                    curx = Math.min(mat.length - 1, curV);
                    cury = curV - curx;
                } else {
                    // 本次 x 减小 下次 x 增大
                    cury = Math.min(mat[0].length - 1, curV);
                    curx = curV - cury;
                }
                index = (index + 1) % 2;
                sign = !sign;
            }
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution().findDiagonalOrder(new int[][]{{1,2,3}, {4,5,6},{7,8,9}});
    }
}
