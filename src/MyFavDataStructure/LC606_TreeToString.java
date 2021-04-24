package MyFavDataStructure;

public class LC606_TreeToString {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        if (t.left == null && t.right == null) {
            return String.valueOf(t.val);
        }
        if (t.right == null) {
            return t.val + "(" + tree2str(t.left) + ")";
        }
        return t.val +  "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
    }
}
