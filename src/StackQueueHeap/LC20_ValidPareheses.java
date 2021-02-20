package StackQueueHeap;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC20_ValidPareheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.offerFirst(c);
            } else if (stack.isEmpty()) {
                return false;
            }  else if ((c == ')' && stack.peekFirst() == '(')
                    || (c == ']' && stack.peekFirst() == '[')
                    || (c == '}' && stack.peekFirst() == '{')) {
                stack.pollFirst();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
