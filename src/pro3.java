import java.util.HashMap;

public class pro3 {
    class Solution1 {
        public int lengthOfLongestSubstring(String s) {
            int ans=0;
            int length = s.length();
            for(int i=length-1;i>=0;i--){
                HashMap<Character,Integer> hashMap = new HashMap<>();
                int len = 0;
                for(int j=i;j>=0;j--){
                    if(hashMap.containsKey(s.charAt(j))) break;
                    else {
                        hashMap.put(s.charAt(j),1);
                        len++;
                    }
                }
                ans=Math.max(ans,len);
            }

            return ans;
        }
    }
}
