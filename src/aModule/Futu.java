package aModule;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Futu {

    static Map<Integer, Integer> map = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    static {

        map.put(10, 10);
        map.put(5, 15);
        map.put(0, 20);
    }
//    5 * 10 + 5 * 15 + 5 * 20
    public static void main(String[] argv) {
        System.out.println(5 * 10 + 5 * 15 + 5 * 20);
        int number = 15;
        int sum = 0;
        for(Integer key : map.keySet()) {
            if(number >= key) {
                sum +=((number - key) * map.get(key));
                number = key;
            } else {
                continue;
            }
        }
        System.out.println(sum);
//        cal(number);
    }

    public static int cal(int number) {

        return 1;
    }
}
