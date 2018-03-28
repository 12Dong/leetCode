public class pro4 {
    static class Solution {
        static public String longestPalindrome(String s) {
            int l=0;
            int length = s.length();
            char ma[] = new char[length*2];
            int mp[] = new int[length*2];
            ma[l++]='$';
            ma[l++]='#';
            for(int i=0;i<length;i++){
                ma[l++]=s.charAt(i);
                ma[l++]='#';
            }
            int id = 0;
            int Max=0;
            for(int i=0;i<l;i++){
                mp[i]=(Max>i?Math.min(mp[2*id-i],Max-i):1);
                while(ma[i+mp[i]]==ma[i-mp[i]]) mp[i]++;
                if(i+mp[i]>Max){
                    Max=i+mp[i];
                    id=i;
                }
            }
            int ans=0;
            for(int i=0;i<l;i++){
                ans=Math.max(ans,mp[i]-1);
            }
            return s.substring(id-ans/2,id+ans/2);
        }
    }
    static public void main(String argv[]){
        pro4 pro = new pro4();
        System.out.println(Solution.longestPalindrome( "babad"));
    }
}
