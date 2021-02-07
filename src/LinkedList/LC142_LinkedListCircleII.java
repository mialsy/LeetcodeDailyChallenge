package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class LC142_LinkedListCircleII {
    // solution one: use two pointer
    // Time: O(n)
    // Space: O(1)
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pos = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                while (pos != slow) {
                    pos = pos.next;
                    slow = slow.next;
                }
                return pos;
            }
        }
        return null;
    }

    // solution two: use hashset
    // space incread to O(n)
    public ListNode deleteCycle(ListNode head, boolean useHash) {
        ListNode pos = head;

        Set<ListNode> visited = new HashSet<>();

        while (pos != null ) {
            if (visited.contains(pos)) {
                return pos;
            }
            visited.add(pos);
            pos = pos.next;
        }

        return null;
    }
}
