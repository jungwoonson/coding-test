package reetcode.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MyHashSetTest {

    @Test
    void add() {
        MyHashSet set = new MyHashSet();

        set.add(1);

        assertThat(set.contains(1)).isTrue();
        assertThat(set.contains(2)).isFalse();
    }

    @Test
    void remove() {
        MyHashSet set = new MyHashSet();
        set.add(1);
        set.add(2);

        set.remove(1);

        assertThat(set.contains(1)).isFalse();
        assertThat(set.contains(2)).isTrue();
    }

    @Test
    void contains() {
        MyHashSet set = new MyHashSet();
        set.add(1);

        boolean actual1 = set.contains(1);
        boolean actual2 = set.contains(2);

        assertThat(actual1).isTrue();
        assertThat(actual2).isFalse();
    }
}