package MyFavDataStructure;

public class LC222_CountNode {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight == rightHeight) {
            // left subtree is full
            return countNodes(root.right) + (1<<leftHeight);
        } else {
            // right subtree is full
            return countNodes(root.left) + (1<<rightHeight);
        }

    }

    private int getHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height;
    }
}
