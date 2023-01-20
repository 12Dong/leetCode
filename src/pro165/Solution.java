package pro165;

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int index = 0;
        while(index < v1.length && index < v2.length) {
            String t1 = v1[index];
            String t2 = v2[index];
            Integer n1 = Integer.valueOf(t1);
            Integer n2 = Integer.valueOf(t2);
            if(n1 > n2) {
                return 1;
            } else if(n2 > n1){
                return -1;
            } else {
                index++;
            }
        }
        if(index == v1.length && index == v2.length) {
            return 0;
        } else if(index == v1.length) {
            for(; index < v2.length; index ++) {
                String t = v2[index];
                Integer n = Integer.valueOf(t);
                if(n > 0) {
                    return -1;
                }
            }
            return 0;
        } else if(index == v2.length) {
            for(; index < v1.length; index ++) {
                String t = v1[index];
                Integer n = Integer.valueOf(t);
                if(n > 0) {
                    return 1;
                }
            }
            return 0;
        } else {
            // useless
            return 0;
        }
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().compareVersion("1.01", "1.001"));
    }
}
