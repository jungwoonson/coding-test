package beakjoon.no010큐;

public class MyArrayQueue<E> {

    private Object[] data;
    private int frontIndex;
    private int rearIndex;
    private int capacity;
    private int size;

    public MyArrayQueue(int maxCapacity) {
        this.data = new Object[maxCapacity];
        this.frontIndex = 0;
        this.rearIndex = 0;
        this.capacity = maxCapacity;
        this.size = 0;
    }

    public boolean enqueue(E element) {
        if (size == capacity) {
            return false;
        }

        rearIndex = (rearIndex + 1) % capacity;
        data[rearIndex] = element;
        size++;
        return true;
    }

    public E dequeue() {
        if (size == 0) {
            return null;
        }
        E value = (E) data[frontIndex];
        data[frontIndex] = null;
        frontIndex = (frontIndex + 1) % capacity;
        size--;
        return value;
    }
}
