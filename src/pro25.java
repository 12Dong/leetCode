public class pro25 {
    static public int divide(int dividend, int divisor) {
        if(divisor==-1 && (long)dividend<=Integer.MIN_VALUE) return Integer.MAX_VALUE;
        if(divisor==1 && (long)dividend>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        int ans=0;
        long mul = dividend*divisor;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while(dividend>=divisor){
            dividend-=divisor;
            ans++;
            if(ans==Integer.MAX_VALUE && dividend>=divisor) return Integer.MAX_VALUE;
        }
        if(mul<0 && ans==Integer.MAX_VALUE && dividend<0) return Integer.MAX_VALUE;
        if(dividend<0) ans--;
        if(mul>0) return ans;
        else return -ans;
    }
    static public void main(String argv[]){
        System.out.println(divide(-2147483648
                ,-1));
    }

}
