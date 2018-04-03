public class pro4 {
    static class Solution {
        static public String longestPalindrome(String s) {
            int length = s.length();
            boolean dp[][] = new boolean[length][length];
            for(int i=0;i<length;i++) dp[i][i]=true;
            int Max=1;
            int ansst=0,ansed=0;
            for(int i=0;i<length-1;i++){
                if(s.charAt(i)==s.charAt(i+1)){
                    dp[i][i+1]=true;
                    if(dp[i][i+1]==true && Max<2){
                        Max = 2;
                        ansst = i;
                        ansed = i+1;
                    }
                }
            }

            for(int len=3;len<=length;len++){
                for(int st=0,ed;(ed=st+len-1)<length;st++){
                    if(s.charAt(st)==s.charAt(ed)){
                        dp[st][ed]=dp[st+1][ed-1];
                        if(dp[st][ed]==true && ed-st+1>Max){
                            Max = ed-st+1;
                            ansst = st;
                            ansed = ed;
                        }
                    }
                }

            }

//            for(int i=0;i<length;i++){
//                for(int j=0;j<length;j++){
//                    System.out.print(dp[i][j]+" ");
//                }
//                System.out.println();
//            }
            return s.substring(ansst,ansed+1);
        }
    }
    static public void main(String argv[]){
        pro4 pro = new pro4();
        System.out.println(Solution.longestPalindrome( "cbbd"));
    }
}
