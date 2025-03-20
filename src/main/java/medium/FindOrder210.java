package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 课程表 II
 * <p>
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。
 * 给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 *
 * @author jd95288
 * @date 2025-03-16 21:58
 */
public class FindOrder210 {

    int[] res;
    List<Integer>[] g;
    int[] inDegree;
    ArrayDeque<Integer> queue;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        res = new int[numCourses];
        inDegree = new int[numCourses];
        g = new List[numCourses];
        queue = new ArrayDeque<>();
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];
            g[from].add(to);
            inDegree[to]++;
        }
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer from = queue.poll();
                res[index++] = from;
                for (Integer to : g[from]) {
                    if (--inDegree[to] == 0) {
                        queue.offer(to);
                    }
                }
            }
        }
        if (index != numCourses) {
            return new int[0];
        } else {
            return res;
        }
    }

}
