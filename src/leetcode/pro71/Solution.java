package leetcode.pro71;

import java.util.Stack;

public class Solution {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
       path = path.replaceAll("[/]+", "/");
       String[] paths = path.split("/");
       for(int i = 0; i < paths.length; i++) {
           if(paths[i].equals("") ) {

           } else if(paths[i].equals(".")) {
               continue;
           } else if(paths[i].equals("..")) {
               if(!stack.isEmpty()) {
                   stack.pop();
               }
           } else {
               stack.add("/" + paths[i]);
           }
       }
       String ans = "";
       while(!stack.isEmpty()) {
           ans = stack.pop() + ans;
       }
       return ans.length() == 0 ? "/" : ans;
    }


    public static void main(String[] argv) {
        System.out.println(new Solution().simplifyPath("/home/"));
        System.out.println(new Solution().simplifyPath("/../"));
        System.out.println(new Solution().simplifyPath("/home//foo/"));
        System.out.println(new Solution().simplifyPath("/a/./b/../../c/"));

    }

}
