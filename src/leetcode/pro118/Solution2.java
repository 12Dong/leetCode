package leetcode.pro118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new LinkedList<>();
        if(numRows >= 1) {
            ans.add(Arrays.asList(1));
        }
        for(int i = 2; i <= numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            List<Integer> last = ans.get(ans.size() - 1);
            for(int j = 0; j < i; j++) {
                if(j == 0) {
                    cur.add(1);
                } else if(j == i - 1) {
                    cur.add(1);
                } else {
                    cur.add(last.get(j - 1) + last.get(j));
                }
            }
            ans.add(cur);
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution2().generate(5);
    }
}
