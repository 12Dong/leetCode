import java.util.*;

public class pro49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0) return null;
        Map<String,Vector<Integer>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String str = strs[i];
            char tmp[] = str.toCharArray();
            Arrays.sort(tmp);
            str = String.valueOf(tmp);
            Vector<Integer> v;
            if(map.get(str)==null) {
                v = new Vector<>();
            }
            else {
                v = map.get(str);
            }
            v.add(i);
            map.put(str,v);
        }
        List<List<String>> ans = new ArrayList<>();
        for(Vector<Integer> v:map.values()){
            List<String> list = new ArrayList<>();
            for(int index:v){
                list.add(strs[index]);
            }
            ans.add(list);
        }
        return ans;
    }
    static public void main(String argv[]){
        String[] str={"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new pro49().groupAnagrams(str));
    }
}
