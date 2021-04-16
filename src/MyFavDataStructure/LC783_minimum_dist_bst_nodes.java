package MyFavDataStructure;

public class LC783_minimum_dist_bst_nodes {
    public int minDiffInBST(TreeNode root) {
        int[] min = {Integer.MAX_VALUE};
        int[] prev = {-1};
        rec(root, prev, min);
        return min[0];

    }

    private void rec(TreeNode root, int[] prev, int[] min) {
        if (root == null) {
            return;
        }

        rec(root.left, prev, min);
        // if range not given, can set to null
        if (prev[0] == -1) {
            prev[0] = root.val;
        } else {
            min[0] = Math.min(min[0], root.val - prev[0]);
            prev[0] = root.val;
        }
        rec(root.right, prev, min);
    }
}
