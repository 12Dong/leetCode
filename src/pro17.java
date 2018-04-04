import java.util.*;

public class pro17 {
    static char map[][] = { {'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    static int len;
    static Map<Character,Integer> m = new HashMap<>();
    static List<String> list=null;
    static public List<String> letterCombinations(String digits) {
        list = new ArrayList<>();
        if (digits.isEmpty()) return list;
        len = digits.length();
        for(int i=0;i<9;i++){
            m.put((char)(2+i),i);
        }
        dfs(0,"");
        return list;
    }
    static void dfs(int num,String str){
        if(num==len){
            list.add(str);
            return;
        }
        int length  = map[num].length;
        for(int i=0;i<length;i++){
            dfs(num+1,str+map[num][i]);
        }
    }
    static public void main(String argv[]){
        List<String> list = letterCombinations("23");
        for(String str:list){
            System.out.println(str);
        }
    }

}
