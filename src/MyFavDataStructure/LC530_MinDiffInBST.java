package MyFavDataStructure;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC530_MinDiffInBST {
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;

        Deque<TreeNode> stack = new ArrayDeque<>();

        Integer prev = null;

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.offerFirst(root);
                root = root.left;
            } else {
                root = stack.pollFirst();
                if (prev != null) {
                    min = Math.min(min, root.val - prev);
                }
                prev = root.val;
                root = root.right;
            }
        }
        return min;
    }
}
