package StackQueueHeap;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC232_QueueByStack {
    private Deque<Integer> stackBuf;
    private Deque<Integer> stackOut;

    /** Initialize your data structure here. */
    public LC232_QueueByStack() {
        stackBuf = new ArrayDeque<>();
        stackOut = new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackBuf.offerFirst(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stackOut.isEmpty()) {
            move();
        }
        return stackOut.pollFirst();
    }

    private void move() {
        while (!stackBuf.isEmpty()) {
            stackOut.offerFirst(stackBuf.pollFirst());
        }
    }
    /** Get the front element. */
    public int peek() {
        if (stackOut.isEmpty()) {
            move();
        }
        return stackOut.peekFirst();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackOut.isEmpty() && stackBuf.isEmpty();
    }
}
