package GraphSearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LC207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        int[] indegs = new int[numCourses];

        for (int[] pair: prerequisites) {
            adjList.get(pair[1]).add(pair[0]);
            indegs[pair[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < indegs.length; i++) {
            if (indegs[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;

            for (int dep : adjList.get(pre)) {
                indegs[dep]--;
                if (indegs[dep] == 0) queue.offer(dep);
            }
        }
        return numCourses == 0 ? true: false;

    }
}
