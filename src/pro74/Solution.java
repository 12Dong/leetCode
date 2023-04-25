package pro74;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int curx = 0;
        int cury = m - 1;
        while(curx < n && cury >= 0) {
            if(matrix[curx][cury] < target) {
                curx++;
            } else if(matrix[curx][cury] == target) {
                return true;
            } else {
                cury--;
            }
        }
        return false;
    }
}
