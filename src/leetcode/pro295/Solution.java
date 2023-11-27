package leetcode.pro295;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {



    class MedianFinder {

        PriorityQueue<Integer> big;
        PriorityQueue<Integer> small;

        public MedianFinder() {
            big = new PriorityQueue<>();
            small = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
        }

        public void addNum(int num) {
            if(small.size() <= big.size()) {
                if(big.isEmpty()) {
                  small.add(num);
                } else if(big.peek() < num) {
                    small.add(big.poll());
                    big.add(num);
                } else {
                    small.add(num);
                }
            } else {
                if(small.peek() >= num) {
                    big.add(small.poll());
                    small.add(num);
                } else {
                    big.add(num);
                }
            }
        }

        public double findMedian() {
            int total = small.size() + big.size();
            if(total % 2 == 1) {
                return small.peek();
            } else {
                return 1.0 * (small.peek() + big.peek()) / 2.0d;
            }
        }
    }
}
