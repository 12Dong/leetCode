import java.util.Arrays;

public class pro14 {
    static public String longestCommonPrefix(String[] strs) {
        String prefix = new String();
        if(strs==null || strs.length==0) return prefix;
        Arrays.sort(strs);
        String strShortest  = strs[0];
        String strLongest = strs[strs.length-1];
        boolean flag = true;
        for(int i=0;i<strShortest.length();i++){
            if(strShortest.charAt(i)==strLongest.charAt(i)){

            }else
            {
                flag =  false;
                prefix = strShortest.substring(0,i);
                break;
            }
        }
        if(flag==true) return strShortest;
        return prefix.toString();
    }
    static public void main(String argv[]){
        String[] strs={"aaaa","aaab","aaac","aaaab"};
        System.out.println(longestCommonPrefix(strs));
    }
}
