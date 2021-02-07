package LinkedList;

public class LC237_DeleteNode {
    public void deleteNode(ListNode node) {
        ListNode cur = node;

        if (cur == null) {
            return;
        }

        ListNode prev = null;

        while (cur.next != null) {
            cur.val = cur.next.val;
            prev = cur;
            cur = cur.next;
        }

        prev.next = null;
    }
}
