package leetcode.pro380;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

    Random random = new Random();
    static int index = -1;
    int[] nums = new int[200005];
    Map<Integer, Integer> valueLocationMap = new HashMap<>();

    public RandomizedSet() {
        nums = new int[200005];
        index = -1;
        valueLocationMap = new HashMap<>();
    }

    public boolean insert(int val) {
        if(valueLocationMap.containsKey(val)) {
            return false;
        }
        valueLocationMap.put(val, ++index);
        nums[index] = val;
        return true;
    }

    public boolean remove(int val) {
        if(!valueLocationMap.containsKey(val)) {
            return false;
        }
        int location = valueLocationMap.remove(val);
        if(location != index) {
            valueLocationMap.put(nums[index], location);
        }
        nums[location] = nums[index--];
        return true;
    }

    public int getRandom() {
        return nums[random.nextInt(index + 1)];
    }
}
