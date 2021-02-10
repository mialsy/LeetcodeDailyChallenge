package MyFavDataStructure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC1110_DeleteNodeAndReturnForest {
    // postorder traverse
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();

        Set<Integer> toDel = new HashSet<>();
        for (int num: to_delete) toDel.add(num);

        dfs(null, root, toDel, res);

        if (!toDel.contains(root.val)) res.add(root);
        return res;
    }

    private void dfs(TreeNode parent, TreeNode root, Set<Integer> toDel, List<TreeNode> res) {
        if (root == null) {
            return;
        }

        dfs(root, root.left, toDel, res);
        dfs(root, root.right, toDel, res);

        if (toDel.contains(root.val)) {
            if (parent != null && parent.left == root) parent.left = null;
            if (parent != null && parent.right == root) parent.right = null;
            if (root.left != null) res.add(root.left);
            if (root.right != null) res.add(root.right);
        }

    }
}
