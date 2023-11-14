package leetcode.pro208;

public class Solution {
    class Trie {

        Trie[] tries = null;
        boolean end = false;

        public Trie() {
            tries = new Trie[26];
            end = false;
        }

        public void insert(String word) {
            Trie trie = this;
            for(int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                int index = c - 'a';
                if(trie.tries[index] == null) {
                    trie.tries[index] = new Trie();
                }
                trie = trie.tries[index];
            }
            trie.end = true;
        }

        public boolean search(String word) {
            Trie trie = this;
            for(int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                int index = c - 'a';
                if(trie.tries[index] == null) {
                    return false;
                } else {
                    trie = trie.tries[index];
                }
            }
            return trie.end;
        }

        public boolean startsWith(String prefix) {
            Trie trie = this;
            for(int i = 0; i < prefix.length(); i++) {
                Character c = prefix.charAt(i);
                int index = c - 'a';
                if(trie.tries[index] == null) {
                    return false;
                } else {
                    trie = trie.tries[index];
                }
            }
            return true;
        }
    }
}
