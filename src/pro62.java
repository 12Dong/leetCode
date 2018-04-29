public class pro62 {
    long dp[][];
    public int uniquePaths(int m, int n) {
        dp = new long[120][120];
        if(m==1 || n==1) return 1;
        long ans = 1;
        //C(m,m+n)
        dp[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
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
        return (int)dp[m-1][n-1];
    }
    static public void main(String argv[]){
        System.out.println(new pro62().uniquePaths(2,2));
    }
}
