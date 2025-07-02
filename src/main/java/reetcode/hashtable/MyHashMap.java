package reetcode.hashtable;

import java.util.Arrays;

class MyHashMap {

    private static final int VOLUME = 1_000_001;
    private static final int EMPTY = -1;

    private final int[] values = new int[VOLUME];

    public MyHashMap() {
        Arrays.fill(values, EMPTY);
    }

    public void put(int key, int value) {
        values[key] = value;
    }
    
    public int get(int key) {
        return values[key];
    }
    
    public void remove(int key) {
        values[key] = EMPTY;
    }
}