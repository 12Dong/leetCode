package leetcode.pro240;

public class Solution4 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int x = 0;
        int y = m - 1;
        while(x < n && y >= 0) {
            if(matrix[x][y] < target) {
                x++;
            } else if(matrix[x][y] == target) {
                return true;
            } else {
                y--;;
            }
        }
        return false;
    }
}
