package leetcode.pro165;

import leetcode.pro41.Solution4;

public class Solution2 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int index = 0;
        while(index < v1.length && index < v2.length) {
            int n1 = Integer.valueOf(v1[index]);
            int n2 = Integer.valueOf(v2[index]);
            if(n1 != n2) {
                return n1 > n2 ? 1 : -1;
            }
            index++;
        }
        if(index < v1.length) {
            // version1 长
            while(index < v1.length) {
                int n1 = Integer.valueOf(v1[index]);
                if(n1 != 0) {
                    return 1;
                }
                index++;
            }
        }

        if(index < v2.length) {
            // version2 长
            while(index < v2.length) {
                int n2 = Integer.valueOf(v2[index]);
                if(n2 != 0) {
                    return -1;
                }
                index++;
            }
        }
        return 0;
    }


    public static void main(String[] argv) {
        new Solution2().compareVersion("1", "1.1");
    }
}
