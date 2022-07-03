package pro118;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(j == 0) {
                    cur.add(1);
                } else if(j == i) {
                    cur.add(1);
                } else {
                    cur.add(ans.get(i - 1).get(j -1 ) + ans.get(i - 1).get(j));
                }
            }
            ans.add(cur);
        }
        return ans;
    }

    public static void main(String[] argv){
        new Solution().generate(5);
    }
}
