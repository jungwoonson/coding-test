package leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {

    private Random rand;
    private Map<Integer, Integer> map;
    private List<Integer> list;

    public RandomizedSet() {
        rand = new Random();
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, map.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int currentIndex = map.get(val);
        int lastIndex = list.size() - 1;

        map.put(list.get(lastIndex), currentIndex);
        map.remove(val);

        list.set(currentIndex, list.get(lastIndex));
        list.remove(lastIndex);

        return true;
    }

    public int getRandom() {
        int idx = rand.nextInt(list.size());
        return list.get(idx);
    }
}
