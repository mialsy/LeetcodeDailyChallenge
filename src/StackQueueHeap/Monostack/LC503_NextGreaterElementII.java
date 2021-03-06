package StackQueueHeap.Monostack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LC503_NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Deque<Integer> monostack = new ArrayDeque<>();

        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * nums.length; i++) {
            int index = i % nums.length;
            // store index in stack in order to fill the original array
            while (!monostack.isEmpty() && nums[monostack.peekFirst()] < nums[index]) {
                int out = monostack.pollFirst();
                res[out] = nums[index];
            }
            monostack.offerFirst(index);
        }
        return res;
    }
}
