package leetcode.pro378;

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int l = matrix[0][0];
        int r = matrix[matrix.length - 1][matrix[0].length - 1];
        while(l < r) {
//                        int mid = left + ((right - left) >> 1);
            int middle = l + (( r -l ) >> 2);
            int v = lessThan(matrix, middle);
            if(v < k) {
                l = middle + 1;
            } else {
                r = middle;
            }
        }
        return l;
    }

    public int lessThan(int[][] matrix, int num) {
        int n = matrix.length;
        int m = matrix[0].length;
        int nn = n - 1;
        int mm = 0;
        int cnt = 0;
        while(nn >= 0 && mm < m) {
            if(matrix[nn][mm] <= num) {
                cnt += (nn + 1) ;
                mm++;
            } else {
                nn--;
            }
        }
        return cnt;
    }

    public static void main(String[] argv) {
//        System.out.println(new Solution().kthSmallest(new int[][] {{-5, -4},{-5, -4}},2));
        System.out.println((-9) / 2);
    }

//    1 2 3 4 5
//    1 2 3 4 5
//    1 2 3 4 5
//    1 2 3 4 5
//    1 2 3 4 5
}
