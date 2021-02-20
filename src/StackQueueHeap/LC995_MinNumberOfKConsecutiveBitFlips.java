package StackQueueHeap;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC995_MinNumberOfKConsecutiveBitFlips {
    public int minKBitFlips(int[] A, int K) {
        int res = 0;
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < A.length; i++) {
            if (queue.size() > 0 && i >= queue.peek() + K) {
                queue.poll();
            }

            if (queue.size() % 2 == A[i]) {
                if (i + K > A.length) return -1;
                queue.offer(i);
                res += 1;
            }
        }
        return res;
    }
}
