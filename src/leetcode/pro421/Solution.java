package leetcode.pro421;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    static class Trie {
        Trie[] tree;

        boolean end;

        Trie() {
            tree = new Trie[2];
            end = false;
        }
    }

    public int findMaximumXOR(int[] nums) {
        Trie root = new Trie();
        for(int num : nums) {
            add(num, root);
        }
        int ans = 0;
        for(int num : nums) {
            Trie cur = root;
            int cc = 0;
            for(int i = maxL; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if(cur.tree[1 - bit] != null) {
                    cc += (1 << i);
                    cur = cur.tree[1 - bit];
                } else {
                    cur = cur.tree[bit];
                }
            }
            ans = Math.max(ans, cc);
        }
        return ans;
    }

    static int maxL = 31;

    public void add(int num, Trie root) {
        Trie cur = root;
        for(int i = maxL; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if(cur.tree[bit] == null) {
                cur.tree[bit] = new Trie();
            }
            cur = cur.tree[bit];
        }
        cur.end = true;
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().findMaximumXOR(new int[]{3,10,5,25,2,8}));
    }
}
