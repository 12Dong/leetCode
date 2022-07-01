package pro85;

import java.util.Stack;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] heigth = new int[m][n+2];
        for(int i = 0; i <m; i++){
            for(int j = 0; j <n; j++) {
                if(i == 0) {
                    heigth[i][j+1] = matrix[i][j] == '1' ? 1 : 0;
                    continue;
                }
                heigth[i][j+1] = matrix[i][j] == '1' ? heigth[i-1][j+1] + 1 : 0;
            }
        }

        int ans = 0;
        n = heigth[0].length;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                while(!stack.isEmpty() && heigth[i][stack.peek()]> heigth[i][j]) {
                    int cur = stack.pop();
                    int curH = heigth[i][cur];
                    int curR = j - 1;
                    int curL = stack.peek();
                    ans = Integer.max(ans, (curR -curL) * curH);
                }
                stack.add(j);
            }
            stack.clear();;
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution().maximalRectangle(matrix);
    }
    
    public static char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
    
    }

