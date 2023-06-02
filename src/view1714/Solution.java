package view1714;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public int[] smallestK(int[] arr, int k) {

        if(k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = (int) o1;
                int i2 = (int) o2;
                return i2 - i1;
            }
        });
        for(int i = 0 ; i < arr.length; i++) {
            if(pq.size() < k) {
                pq.add(arr[i]);
            } else {
                if(pq.peek() > arr[i]) {
                    pq.poll();
                    pq.add(arr[i]);
                }
            }
        }
        int[] ans = new int[k];
        int index = 0;
        while(!pq.isEmpty()) {
            ans[index++] = pq.poll();
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution().smallestK(new int[]{1,3,5,7,2,4,6,8}, 4);
    }
}
