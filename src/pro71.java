import java.util.Stack;

public class pro71 {
    public String simplifyPath(String path) {
        String strs[] = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String str:strs){
            if(str.equals("") || str.equals(".")) continue;
            else if(str.equals("..")){
                if(!stack.empty()){
                    stack.pop();
                }
            }
            else stack.push(str);
        }
        Stack<String> ans = new Stack<>();
        while(!stack.empty()){
            String top = stack.pop();
            ans.push(top);
        }
        String Ans="";
        while(!ans.empty()){
            Ans+="/"+ans.pop();
        }
        if(Ans.equals("")) return "/";
        return Ans;
    }
    static public void main(String argv[]){
        System.out.println(new pro71().simplifyPath("/a/./b/../../c/"));
    }
}
