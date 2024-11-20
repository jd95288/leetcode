package hard;

import java.util.*;

/**
 * 新增道路查询后的最短距离II
 * <p>
 * 有 n 个城市，刚开始每一个城市 i 有一条单项道路通向城市 i + 1，
 * 有一个二维数组 queries，queries[i] 表示增加一条从 queries[i][0] 到 queries[i][1] 的单项道路，
 * 返回 answer 数组，answer[i] 表示增加了 queries[i] 之后从城市 0 到城市 n - 1 的最短路径。
 * 增加的路径保证不会出现相交的情况。
 *
 * @author jd95288
 * @date 2024-11-20 10:10
 */
public class ShortestDistanceAfterQueries3244 {

    public int[] shortestDistanceAfterQueries_v1(int n, int[][] queries) {
        int ql = queries.length;
        int[] res = new int[ql];
        int[] interval = new int[n - 1];
        Arrays.setAll(interval, i -> i + 1);
        int shortestPath = n - 1;
        for (int i = 0; i < ql; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            while (interval[l] < r) {
                int next = interval[l];
                interval[l] = r;
                l = next;
                shortestPath--;
            }
            res[i] = shortestPath;
        }
        return res;
    }

}
