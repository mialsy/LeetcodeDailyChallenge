package MyFavDataStructure;

public class LC776_SplitBST {
    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode[] res = new TreeNode[2];

        return split(root, V, res);

    }

    private TreeNode[] split(TreeNode root, int V, TreeNode[] res) {
        if (root == null) return new TreeNode[] {null, null};

        if (root.val <= V) {
            res = split(root.right, V, res);
            root.right = res[0];
            res[0] = root;
        } else {
            res = split(root.left, V, res);
            root.left = res[1];
            res[1] = root;
        }
        return res;
    }
}
