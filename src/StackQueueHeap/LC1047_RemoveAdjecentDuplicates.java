package StackQueueHeap;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC1047_RemoveAdjecentDuplicates {
    public String removeDuplicates(String S) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < S.length(); i++) {
            char current = S.charAt(i);
            boolean repeated = false;
            while (!stack.isEmpty() && stack.peekFirst() == current) {
                stack.pollFirst();
                repeated = true;
            }
            if (!repeated) stack.offerFirst(current);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();

    }
}
