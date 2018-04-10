public class pro50 {
    public double myPow(double x, int n) {
        int sign=1;
        if(n<0){
            sign=-1;
            n=-n;
        }
        return sign<0? 1/pow(x,n) : pow(x,n) ;
    }


    public double pow(double x,int n){
        if(n==0) return 1;
        if(n==1) return x;
        if(n%2==0) {
            double tmp=pow(x,n/2);
            return tmp*tmp;
        }else{
            double tmp=pow(x,n/2);
            return tmp*tmp*x;
        }
    }

    static public void main(String argv[]){
        double ans = new pro50().myPow(2,-2147483648);
        System.out.println(String.format("%.5f\n",ans));
    }
}
