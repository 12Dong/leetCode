package pro127;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Set<String> startVisit = new HashSet<>();
        startVisit.add(beginWord);
        Set<String> endVisit = new HashSet<>();
        endVisit.add(endWord);
        int step = 1;
        while(!startVisit.isEmpty() && !endVisit.isEmpty()) {
            if(startVisit.size() > endVisit.size()) {
                Set<String> tmp = startVisit;
                startVisit = endVisit;
                endVisit = tmp;
            }
            Set<String> nextVisit = new HashSet<>();
            for(String cur : startVisit) {
                if(isArrived(cur, endVisit, nextVisit, endWord, wordSet, visited)) {
                    return step + 1;
                }
            }
            startVisit = nextVisit;
            step++;
        }
        return 0;
    }

    public boolean isArrived(String cur,
                             Set<String> endVisited,
                             Set<String> nextVisit,
                             String endWord,
                             Set<String> wordList,
                             Set<String> visit) {
        char[] curCharArray = cur.toCharArray();
        for(int index = 0; index < cur.length();index++) {
            char curChar = cur.charAt(index);
            for(char c = 'a'; c <='z'; c++){
                if(c == curChar) {
                    continue;
                }
                curCharArray[index] = c;
                String replaceStr = String.valueOf(curCharArray);
                if(wordList.contains(replaceStr)){
                    if(endVisited.contains(replaceStr)){
                        return true;
                    }
                    if(!visit.contains(replaceStr)) {
                        nextVisit.add(replaceStr);
                        visit.add(replaceStr);
                    }
                }
                curCharArray[index] = curChar;
            }
        }
        return false;
    }
}