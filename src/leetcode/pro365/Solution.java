package leetcode.pro365;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution {
//    3 5 4
//    0 5
//    3 0
//    3 5
//    0 0
//    3 2
//    0 3
//    0 2
//    3 3
//    2 0
//    2 5
//    3 4

    static class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
        @Override
        public boolean equals(Object obj) {
            Pair p = (Pair) obj;
            return this.a == p.a && this.b == p.b;
        }
    }

    static boolean result = false;
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        Set<Pair> set = new HashSet<>();
        result = false;
        dfs(set, jug1Capacity, jug2Capacity, 0, 0, targetCapacity);
        return result;
    }

    public void dfs(Set<Pair> set, int capa, int capb, int a, int b, int tar) {
        if(a == tar || b == tar || a + b == tar) {
            result = true;
        }

        if(result) {
            return;
        }

        if(a != capa && !set.contains(new Pair(capa, b))) {
            set.add(new Pair(capa, b));
            dfs(set, capa, capb, capa, b, tar);
        }

        if(result) {
            return;
        }

        if(b != capb && !set.contains(new Pair(a, capb))) {
            set.add(new Pair(a, capb));
            dfs(set, capa, capb, a, capb, tar);
        }

        if(result) {
            return;
        }

        if(a != capa) {
            int newa = (a + b) >= capa ? capa : a + b;
            int newb = (a + b) - newa;
            if(!set.contains(new Pair(newa, newb))) {
                set.add(new Pair(newa, newb));
                dfs(set, capa, capb, newa, newb, tar);
            }
        }

        if(result) {
            return;
        }

        if(b != capb) {
            int newb = (a + b) >= capb ? capb : a + b;
            int newa = (a + b) - newb;
            if(!set.contains(new Pair(newa, newb))) {
                set.add(new Pair(newa, newb));
                dfs(set, capa, capb, newa, newb, tar);
            }
        }

        if(result) {
            return;
        }

        if(a != 0) {
            if(!set.contains(new Pair(0, b))) {
                set.add(new Pair(0, b));
                dfs(set, capa, capb, 0, b, tar);
            }
        }

        if(result) {
            return;
        }

        if(b != 0) {
            if(!set.contains(new Pair(a, 0))) {
                set.add(new Pair(a, 0));
                dfs(set, capa, capb, a, 0, tar);
            }
        }


        if(result) {
            return;
        }

    }

    public static void main(String[] argv) {
        System.out.println(new Solution().canMeasureWater(3, 5, 4));
    }
}
