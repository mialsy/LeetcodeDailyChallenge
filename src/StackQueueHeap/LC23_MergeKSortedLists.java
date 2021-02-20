package StackQueueHeap;
import LinkedList.ListNode;

import java.util.PriorityQueue;

public class LC23_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (ListNode n1, ListNode n2) -> {
                    if (n1.val == n2.val) return 0;
                    return n1.val < n2.val? -1: 1;
                });

        for (ListNode head: lists) {
            if (head == null) continue;
            pq.offer(head);
        }


        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while(!pq.isEmpty()) {
            ListNode cur = pq.poll();

            prev.next = cur;
            prev = cur;
            cur = cur.next;
            if (cur != null) pq.offer(cur);
        }

        return dummy.next;




    }
}
