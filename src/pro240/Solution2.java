package pro240;

public class Solution2 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = 0;
        int m = matrix[0].length - 1;
        while(n < matrix.length && m >= 0) {
            int value = matrix[n][m];
            if(value == target) {
                return true;
            } else if(value < target) {
                n ++;
            } else {
                m -- ;
            }
        }
        return false;
    }
}
