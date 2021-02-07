package LinkedList;

// supose input size is n
// Time: O(n)
// Space: O(1)
public class LC206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        // sanity check
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
