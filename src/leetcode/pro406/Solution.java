package leetcode.pro406;

import java.util.Arrays;

public class Solution {

    class People implements Comparable{
        int h;
        int count;


        @Override
        public int compareTo(Object o) {
            People p = (People) o;
            if(this.h == p.h) {
                return this.count - p.count;
            } else {
                return this.h - p.h;
            }
        }
    }

//    [7,0],
//    [4,4],
//    [7,1],
//    [5,0],
//    [6,1],
//    [5,2]]

//    5 7 5 6 4 7
//    当满足 count的情况下 先放 value 小的  没影响

    public int[][] reconstructQueue(int[][] people) {
        People[] peoples = new People[people.length];
        for(int i = 0; i < people.length; i++) {
            People p = new People();
            p.h = people[i][0];
            p.count = people[i][1];
            peoples[i] = p;
        }
        int[][] ans = new int[people.length][2];
        int index = 0;
        Arrays.sort(peoples);
        boolean[] vis = new boolean[peoples.length];
        while(index < people.length) {
            for(int i = 0; i < peoples.length; i++) {
                if(vis[i]) {
                    continue;
                }
                int count = 0;
                for(int j = 0; j < index; j++) {
                    if(ans[j][0] >= peoples[i].h) {
                        count++;
                    }
                }
                if(count == peoples[i].count) {
                    ans[index][0] = peoples[i].h;
                    ans[index][1] = peoples[i].count;
                    vis[i] = true;
                    index++;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] argv) {
        int[][] people = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6, 1},{5,2}};
        new Solution().reconstructQueue(people);
    }
}
