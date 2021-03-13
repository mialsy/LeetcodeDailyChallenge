package StackQueueHeap;

import java.util.ArrayDeque;
import java.util.Queue;

public class LC225_StackByQueue {
    private Queue<Integer> queueBuf;
    private Queue<Integer> queueOut;


    /** Initialize your data structure here. */
    public LC225_StackByQueue() {
        queueBuf = new ArrayDeque<>();
        queueOut = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queueBuf.offer(x);
        while (!queueOut.isEmpty()) {
            queueBuf.offer(queueOut.poll());
        }
        Queue<Integer> tmp = queueOut;
        queueOut = queueBuf;
        queueBuf = tmp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queueOut.poll();
    }

    /** Get the top element. */
    public int top() {
        return queueOut.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queueOut.isEmpty();
    }
}
