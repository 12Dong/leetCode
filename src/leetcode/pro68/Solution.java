package leetcode.pro68;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new LinkedList<>();
        int cntChar = 0;
        List<String> curString = new LinkedList<>();
        for(String word : words) {
            if(cntChar + (curString.size()) + word.length() > maxWidth) {
                String cur = "";
                if(curString.size() != 1) {
                    int blank = (maxWidth - cntChar) / (curString.size() - 1);
                    int rest = (maxWidth - cntChar) % (curString.size() - 1);
                    for(int i = 0; i < curString.size(); i++) {
                        if(i + 1 == curString.size()) {
                            cur += curString.get(i);
                        } else {
                            cur += curString.get(i);
                            for(int j = 0; j < blank; j++) {
                                cur += " ";
                            }
                            if(rest != 0) {
                                cur += " ";
                                rest--;
                            }
                        }
                    }
                } else {
                    cur += curString.get(0);
                    while(cur.length() != maxWidth) {
                        cur += " ";
                    }
                }
                ans.add(cur);
                cntChar = word.length();
                curString.clear();
                curString.add(word);
            } else {
                cntChar += word.length();
                curString.add(word);
            }
        }
        if(!curString.isEmpty()) {
            String cur = "";
            if(curString.size() != 1) {
                int blank = (maxWidth - cntChar) / (curString.size() - 1);
                int last = (maxWidth - cntChar) % (curString.size() - 1);
                for(int i = 0; i < curString.size(); i++) {
                    if(i + 1 == curString.size()) {
                        cur += curString.get(i);
                    } else if(i + 2 == curString.size()) {
                        cur += curString.get(i);
                        if(last != 0) {
                            for(int j = 0; j < last; j++) {
                                cur += " ";
                            }
                        } else {
                            for(int j = 0; j < blank; j++) {
                                cur += " ";
                            }
                        }
                    } else {
                        cur += curString.get(i);
                        for(int j = 0; j < blank; j++) {
                            cur += " ";
                        }
                    }
                }
            } else {
                cur += curString.get(0);
                while(cur.length() != maxWidth) {
                    cur += " ";
                }
            }
            ans.add(cur);
        }

        String lastStr = ans.remove(ans.size() - 1);
        lastStr = lastStr.replaceAll("( )+", " ");
        String[] tmpStrs = lastStr.split(" ");
        String last = String.join(" ", tmpStrs);
        while(last.length() != maxWidth) {
            last += " ";
        }
        ans.add(last);
        return ans;
    }

    public static void main(String[] argv) {
        new Solution().fullJustify(new String[] {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20);
//        String test = "shall         be";
//        test = test.replaceAll("( )+", " ");
//
//        System.out.println(test);
    }
}
/**
 ["This", "is", "an", "example", "of", "text", "justification."]
 16
 ["What","must","be","acknowledgment","shall","be"]
 16
 ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"]
 20


 ["This    is    an","example of text","justification.  "]
 ["What   must   be","acknowledgment  ","shall         be"]
 ["Science is what  we","understand      well","enough to explain to","a computer. Art  is","everything  else  we","do                  "]
 */

// ["This    is    an","example of text","justification.  "]
// ["This    is    an","example  of text","justification.  "]