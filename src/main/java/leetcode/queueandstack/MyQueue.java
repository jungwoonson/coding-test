package leetcode.queueandstack;

import java.util.Stack;

class MyQueue {

    private Stack<Integer> left;
    private Stack<Integer> right;

    public MyQueue() {
        left = new Stack<>();
        right = new Stack<>();
    }
    
    public void push(int x) {
        while (!right.isEmpty()) {
            left.push(right.pop());
        }
        left.push(x);
    }
    
    public int pop() {
        while (!left.isEmpty()) {
            right.push(left.pop());
        }
        return right.pop();
    }
    
    public int peek() {
        while (!left.isEmpty()) {
            right.push(left.pop());
        }
        return right.peek();
    }
    
    public boolean empty() {
        return left.isEmpty() && right.isEmpty();
    }
}