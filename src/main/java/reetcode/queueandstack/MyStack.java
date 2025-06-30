package reetcode.queueandstack;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.add(x);
    }
    
    public int pop() {
        if (queue.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
        return queue.poll();
    }
    
    public int top() {
        if (queue.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
        Integer poll = queue.poll();
        queue.add(poll);
        return poll;
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}