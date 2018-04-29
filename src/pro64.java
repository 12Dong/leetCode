public class pro64 {
    int dp[][];
    public int minPathSum(int[][] grid) {
        dp = new int[500][500];
        int m = grid.length;
        int n = grid[0].length;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1) continue;
                if(i==m-1) dp[i][j]=dp[i][j+1]+grid[i][j];
                else if(j==n-1) dp[i][j]=dp[i+1][j]+grid[i][j];
                else{
                    dp[i][j]=Math.min(dp[i+1][j],dp[i][j+1])+grid[i][j];
                }
            }
        }
        return dp[0][0]+grid[m-1][n-1];
    }
    static public void main(String argv[]){
        int map[][]={{1,3,1}};
        System.out.println(new pro64().minPathSum(map));
    }
}
