package leetcode.pro1268;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        List<List<String>> ans = new LinkedList<>();
        for(int i = 0; i <searchWord.length(); i++) {
            int l = 0;
            int r = products.length - 1;
            String prefix = searchWord.substring(0, i + 1);
            while(l < r) {
                int middle = l +( (r - l) >> 1);
                if(products[middle].compareTo(prefix) >= 0) {
                    r = middle;
                } else {
                    l = middle + 1;
                }
            }

            List<String> cur = new LinkedList<>();
            for(int j = 0; j < 3 && l + j < products.length; j++) {
                if(products[l + j].startsWith(prefix)) {
                    cur.add(products[l + j]);
                }
            }
            ans.add(cur);
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution().suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"}, "mouse");
    }

}

