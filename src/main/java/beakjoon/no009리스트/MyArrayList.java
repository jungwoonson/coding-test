package beakjoon.no009리스트;

import java.util.Arrays;

public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private int size = 0;
    private Object[] data;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int initialCapacity) {
        data = new Object[initialCapacity];
    }

    public int size() {
        return size;
    }

    public void add(E element) {
        growCapacity();
        data[size++] = element;
    }

    public E get(int idx) {
        validateIndex(idx);
        return (E) data[idx];
    }

    public void set(int idx, E element) {
        validateIndex(idx);
        data[idx] = element;
    }

    public void insert(int idx, E element) {
        growCapacity();
        int copyLength = size - idx;
        System.arraycopy(data, idx, data, idx + 1, copyLength);
        data[idx] = element;
        size++;
    }

    public void remove(int idx) {
        validateIndex(idx);
        System.arraycopy(data, idx + 1, data, idx, size - idx - 1);
        size--;
    }

    public void growCapacity() {
        if (size == data.length) {
            int newCapacity = data.length + (data.length >> 1);
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    private void validateIndex(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Index: " + idx + ", Size: " + size);
        }
    }
}
