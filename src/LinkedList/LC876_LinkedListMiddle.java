package LinkedList;

public class LC876_LinkedListMiddle {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next ==null) {
            return head;
        }

        ListNode s = head;
        ListNode f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }

        return s;
    }

}
