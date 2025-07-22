package leetcode.queueandstack;

class MyCircularQueue {

    private final int[] queue;
    private int front;
    private int rear;
    private int size;

    public MyCircularQueue(int k) {
        queue = new int[k];
        front = 0;
        rear = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        size++;
        queue[rear++] = value;
        rear %= queue.length;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        size--;
        front++;
        front %= queue.length;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return rear != 0 ? queue[rear - 1] : queue[queue.length - 1];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == queue.length;
    }
}
