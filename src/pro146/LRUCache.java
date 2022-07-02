package pro146;

import java.util.*;

public class LRUCache {

    private Integer capacity;

    private Deque<Integer> list;

    private Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        list = new LinkedList<Integer>();
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            list.remove(key);
            list.addFirst(key);
            return map.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            map.put(key, value);
            list.remove(key);
            list.addFirst(key);
        } else {
            map.put(key, value);
            if(list.size() < capacity) {
                list.addFirst(key);
            } else {
                Integer popKey = list.removeLast();
                map.remove(popKey);
                list.addFirst(key);
            }
        }
    }

    public static void main(String[] argv){
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3, 3);
        cache.get(2);
    }
}
