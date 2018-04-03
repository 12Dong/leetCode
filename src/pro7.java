public class pro7 {
    static class Solution {
        static public int reverse(int x) {
            boolean flag = x>=0?true:false;
            x = Math.abs(x);
            long ans = 0;
            int last=0;
            while(x!=0){
                ans = ans*10+x%10;
                x/=10;
                if(ans>Integer.MAX_VALUE) return 0;
                if(ans<Integer.MIN_VALUE) return 0;
            }
            if(flag==false) ans=-ans;
            return (int)ans;
        }
    }
    static public void main(String argv[]){
        System.out.println(pro7.Solution.reverse(1534236469));
    }
}
