package MyFavDataStructure;

public class LC617_MergeTwoBinaryTree {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        if (root1 == null) return root2;
        if (root2 == null) return root1;

        TreeNode leftRes = mergeTrees(root1.left, root2.left);
        TreeNode rigthRes = mergeTrees(root1.right, root2.right);

        TreeNode rootMer = new TreeNode(root1.val + root2.val);
        rootMer.left = leftRes;
        rootMer.right = rigthRes;
        return rootMer;
    }
}
