package GraphSearch;

import java.util.ArrayDeque;
import java.util.Queue;

public class LC1091_ShortPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // bfs
        // sancheck

        if (grid == null || grid.length == 0 || grid[0][0] == 1) return -1;
        if (grid.length == 1) return grid[0][0] == 0 ? 1: -1;

        int len = grid.length;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[len][len];

        int[][] dirs = new int[][]{{0, 1},{0, -1},
                {1, 0},{1, -1}, {1, 1},
                {-1, 1}, {-1,0}, {-1, -1}};

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        int step = 1;

        while (!queue.isEmpty()) {
            int qsize = queue.size();

            while (qsize-- > 0) {
                int[] current = queue.poll();

                for (int[] dir: dirs) {
                    int row = current[0] + dir[0];
                    int col = current[1] + dir[1];

                    if (row >= 0 && row < len && col >= 0 && col < len
                            && grid[row][col] == 0 && !visited[row][col]) {
                        if (row == (len - 1) && col ==(len - 1)) return step + 1;
                        queue.offer(new int[]{row, col});
                        visited[row][col] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
