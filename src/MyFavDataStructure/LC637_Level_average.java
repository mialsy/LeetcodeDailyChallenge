package MyFavDataStructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LC637_Level_average {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Double> avgs = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int qsize = queue.size();
            long sum = 0;

            for (int i = 0; i < qsize; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
            }
            avgs.add(((double) sum) / qsize);

        }
        return avgs;
    }
}
