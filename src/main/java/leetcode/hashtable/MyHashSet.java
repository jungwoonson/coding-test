package leetcode.hashtable;

import java.util.ArrayList;
import java.util.List;

class MyHashSet {

    private int BUCKETS = 6000;
    private final List<Integer>[] table;

    public MyHashSet() {
        table = new List[BUCKETS];
        for (int i = 0; i < BUCKETS; i++) {
            table[i] = new ArrayList<>();
        }
    }

    public void add(int key) {
        if (contains(key)) {
            return;
        }
        int bucket = hash(key);
        table[bucket].add(key);
    }
    
    public void remove(int key) {
        if (!contains(key)) {
            return;
        }
        table[hash(key)].remove(table[hash(key)].indexOf(key));
    }
    
    public boolean contains(int key) {
        return table[hash(key)].contains(key);
    }

    private int hash(int key) {
        return key % BUCKETS;
    }
}
