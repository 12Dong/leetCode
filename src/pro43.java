public class pro43 {
    public String multiply(String num1, String num2) {
        int len1=num1.length();
        int len2=num2.length();
        int num[]=new int[len1+len2];
        for(int i=len1-1;i>=0;i--){
            for(int j=len2-1;j>=0;j--){
                int loc1 = i+j;
                int loc2 = i+j+1;

                num[loc2]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                num[loc1]+=num[loc2]/10;
                num[loc2]%=10;
            }
        }

        String ans = new String();
        boolean flag=true;
        for(int i=0;i<num.length;i++){
            if(num[i]!=0) flag=false;
            if(flag)continue;
            char add = (char)('0'+num[i]);
            ans+=add;
        }
        if(flag)return"0";
        return ans;
    }
    static public void main(String argv[]){
        System.out.println(new pro43().multiply("0","10"));
    }
}
