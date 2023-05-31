package leetcode.pro785;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

//    [
//    [1,2,3],
//    [0,2],
//    [0,1,3],
//    [0,2]]
//    false

//    [
//    [1,3],
//    [0,2],
//    [1,3],
//    [0,2]]
//    0 2
//    1
    public boolean isBipartite(int[][] graph) {
        Set<Integer> seta = new HashSet<>();
        Set<Integer> setb = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++) {
            if(vis[i] == false) {
                q.add(i);
                vis[i] = true;
                seta.add(i);
                while(!q.isEmpty()) {
                    int from = q.poll();
                    Set<Integer> fromCur = seta.contains(from) ? seta : setb;
                    for(int index = 0; index < graph[from].length; index++) {
                        int to = graph[from][index];
                        Set<Integer> toCur = seta.contains(to) ? seta : setb.contains(to) ? setb : null;
                        if(fromCur == toCur) {
                            return false;
                        } else if(toCur == null){
                            toCur = fromCur == seta ? setb : seta;
                            toCur.add(to);
                            vis[to] = true;
                            q.add(to);
                        } else {
                            if(vis[to] == false) {
                                q.add(to);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

}
