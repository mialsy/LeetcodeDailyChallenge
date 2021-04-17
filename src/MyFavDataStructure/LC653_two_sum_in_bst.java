package MyFavDataStructure;

public class LC653_two_sum_in_bst {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        return find(root.left, root, k) || find(root, root.right, k);
    }

    private boolean find(TreeNode sm, TreeNode lg, int k) {
        if (sm == null || lg == null) {
            return false;
        } else if (sm.val + lg.val == k && sm.val != lg.val) {
            return true;
        }

        if (sm.val + lg.val < k) {
            return find(sm.right, lg, k) || find(sm, lg.right, k);
        } else {
            return find(sm, lg.left, k) || find(sm.left, lg, k);
        }
    }
}
