package medium;


import java.util.*;

/**
 * 课程表
 * <p>
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 * @author jd95288
 * @date 2025-03-16 21:06
 */
public class CanFinish207 {

    /**
     * 执行通过
     * 不使用记忆化搜索会超时
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] g = new List[numCourses];
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            g[prerequisite[1]].add(prerequisite[0]);
        }
        Set<Integer> visited = new HashSet<>();
        int[] mem = new int[numCourses];
        Arrays.fill(mem, -1);
        boolean res = true;
        for (int i = 0; i < numCourses; i++) {
            visited.add(i);
            res = res && dfs(i, visited, g, mem);
            visited.remove(i);
        }
        return res;
    }

    public boolean dfs(int cur, Set<Integer> visited, List<Integer>[] g, int[] mem) {
        if (g[cur].size() == 0) {
            return true;
        }
        boolean res = true;
        for (Integer next : g[cur]) {
            if (visited.contains(next)) {
                return false;
            }
            visited.add(next);
            if (mem[next] == -1) {
                mem[next] = dfs(next, visited, g, mem) ? 1 : 0;
            }
            res = res && mem[next] == 1;
            visited.remove(next);
        }
        mem[cur] = res ? 1 : 0;
        return res;
    }

}
