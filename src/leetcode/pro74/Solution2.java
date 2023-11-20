package leetcode.pro74;

public class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int x = 0;
        int y = m - 1;
        while(x < n && y >= 0) {
            if(matrix[x][y] == target) {
                return true;
            } else if(matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}
