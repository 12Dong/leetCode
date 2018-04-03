public class pro9 {
    static class Solution {
        static public boolean isPalindrome(int x) {
            if(x<0 || (x>0 && x%10==0)) return false;
            int sum = 0;
            while(x>sum){
                sum = sum*10+x%10;
                x/=10;
            }
            if(sum==x || sum/10==x) return true;
            else return false;
        }
    }
    static public void main(String argv[]){
        System.out.println(pro9.Solution.isPalindrome(10));
    }
}
