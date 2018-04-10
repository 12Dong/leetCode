public class pro62 {
    public int uniquePaths(int m, int n) {
        if(m==1 || n==1) return 1;
        long ans = 1;
        //C(m,m+n)
        m--;
        n--;
        for(int i=m+n;i>m;i--) ans*=i;
        for(int i=1;i<=n;i++) ans/=i;
        return (int)ans;
    }
    static public void main(String argv[]){
        System.out.println(new pro62().uniquePaths(13,23));
    }
}
