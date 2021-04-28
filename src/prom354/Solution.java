package prom354;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    class Envelops implements Comparable {

        int l;
        int w;

        public Envelops(int l, int w){
            this.l = l;
            this.w = w;
        }

        @Override
        public int compareTo(Object o) {
            Envelops e = (Envelops)o;
            if(this.l != e.l){
                return this.l - e.l;
            } else {
                return this.w - e.w;
            }
        }

        @Override
        public String toString() {
            return this.l + "  " + this.w;
        }
    }

    public int maxEnvelopes(int[][] envelopes) {
        int length = envelopes.length;
        Envelops[] es = new Envelops[length];
        for(int i = 0; i < length; i++){
            es[i] = new Envelops(envelopes[i][0], envelopes[i][1]);
        }
        List<Envelops> list = Arrays.stream(es).sorted().collect(Collectors.toList());
//        for(Envelops e : list){
//            System.out.println(e);
//        }
        es = (Envelops[]) list.toArray(es);
        // 排序后的 以 x 为末尾的 最长上升子序列 长度
        int[] dp = new int[length];
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < length; i++){
            for(int j=0; j < i; j++){
                if(es[i].l == es[j].l) continue;
                if(es[i].w > es[j].w){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Integer.max(result, dp[i]);
        }
        return result + 1;
    }

    public static void main(String[] argv){
        System.out.println(new Solution().maxEnvelopes(envelops));
    }

//    static int[][] envelops = new int[][]{{5,4},{6,4},{6,7},{2,3}};
    static int[][] envelops = new int[][]{{1,1},{1,1},{1,1}};
//    static int[][] envelops = new int[][]{{4,5},{4,6},{6,7},{2,3},{1,1}};

}
