public class pro63 {
    int dp[][];
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        dp = new int[120][120];
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0]==0) dp[0][0]=1;
        else {
            dp[0][0]=0;
            return 0;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1) continue;
                if(i==0&&j==0) continue;
                else if(i==0){
                    dp[i][j]=dp[i][j-1];
                }else if(j!=0){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }else if(j==0){
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
    static public void main(String argv[]){
        int map[][]={{0}};
        System.out.println(new pro63().uniquePathsWithObstacles(map));
    }
}
