package StackQueueHeap;

import java.util.PriorityQueue;

public class LC215_KthLagestInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        int i = 0;
        while (i < k)   {
            minheap.offer(nums[i++]);
        }

        while (i < nums.length) {
            int cur = nums[i++];
            if (cur > minheap.peek()) {
                minheap.poll();
                minheap.offer(cur);
            }
        }
        return minheap.peek();

    }
}
