package pro208;

public class Trie {

    private Trie[] children;
    private boolean isEnd;


    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for(int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if(node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new Trie();
            }
            node = node.children[c - 'a'];
         }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = this;
        for(int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            int index = c - 'a';
            if(node.children[index]  == null) return false;
            node = node.children[index];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie node = this;
        for(int i = 0; i < prefix.length(); i++) {
            Character c = prefix.charAt(i);
            int index = c - 'a';
            if(node.children[index]  == null) return false;
            node = node.children[index];
        }
        return true;
    }
}
