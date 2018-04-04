import java.util.ArrayList;
import java.util.List;

public class pro20 {
    static List<String>ans;
    static void dfs(String str,boolean flag,int leftnum,int rightnum,int n){
        if(leftnum==rightnum && leftnum==n){
            ans.add(str);
            return;
        }
        if(flag==true){
            str+=")";
            dfs(str,false,leftnum,rightnum+1,n);
            if(leftnum>rightnum+1) dfs(str,true,leftnum,rightnum+1,n);
        }else{
            str+="(";
            if(leftnum+1<=n)dfs(str,true,leftnum+1,rightnum,n);
            if(leftnum+1<=n)dfs(str,false,leftnum+1,rightnum,n);
        }
    }
    static public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        dfs("(",true,1,0,n);
        dfs("(",false,1,0,n);
        return ans;
    }
    static public void main(String argv[]){
        System.out.println(generateParenthesis(3));
    }
}
