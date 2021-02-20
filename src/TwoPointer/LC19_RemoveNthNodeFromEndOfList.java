package TwoPointer;

import LinkedList.ListNode;

public class LC19_RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = head;
        ListNode prev = dummy;
        ListNode slow = head;

        while (n-- > 0) fast = fast.next;

        while (fast != null) {
            prev = prev.next;
            fast = fast.next;
            slow = slow.next;
        }

        prev.next = slow.next;
        return dummy.next;

    }
}
