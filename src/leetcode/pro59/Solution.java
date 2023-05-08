package leetcode.pro59;

public class Solution {

//    [1,2,3],
//    [8,9,4],
//    [7,6,5]]
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int curx = 0;
        int cury = 0;
        int[][] dir = new int[][]{{0,1}, {1,0}, {0, -1}, {-1, 0}};
        int curDir = 0;
        int cur = 1;
        while(true) {
            nums[curx][cury] = cur ++;
            int nextx = curx + dir[curDir][0];
            int nexty = cury + dir[curDir][1];
            if(nextx < 0 || nextx >= n || nexty < 0 || nexty >= n || nums[nextx][nexty] != 0) {
                curDir = (curDir + 1) % 4;
                nextx = curx + dir[curDir][0];
                nexty = cury + dir[curDir][1];
                if(nextx < 0 || nextx >= n || nexty < 0 || nexty >= n || nums[nextx][nexty] != 0) {
                    break;
                }
                curx = nextx;
                cury = nexty;
            } else {
                curx = nextx;
                cury = nexty;
            }
        }
        return nums;
    }

    public static void main(String[] argv) {
        new Solution().generateMatrix(3);
    }
}
