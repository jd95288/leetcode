package medium;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * 引爆最多的炸弹
 * <p>
 * 给你一个炸弹列表。一个炸弹的 爆炸范围 定义为以炸弹为圆心的一个圆。
 * 炸弹用一个下标从 0 开始的二维整数数组 bombs 表示，其中 bombs[i] = [xi, yi, ri] 。
 * xi 和 yi 表示第 i 个炸弹的 X 和 Y 坐标，ri 表示爆炸范围的 半径 。
 * 你需要选择引爆 一个 炸弹。当这个炸弹被引爆时，所有 在它爆炸范围内的炸弹都会被引爆，这些炸弹会进一步将它们爆炸范围内的其他炸弹引爆。
 * 给你数组 bombs ，请你返回在引爆 一个 炸弹的前提下，最多 能引爆的炸弹数目。
 *
 * @author jd95288
 * @date 2024-07-22 9:24
 */
public class MaximumDetonation2101 {

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int ix = bombs[i][0];
            int iy = bombs[i][1];
            long ir = bombs[i][2];
            for (int j = i + 1; j < n; j++) {
                int jx = bombs[j][0];
                int jy = bombs[j][1];
                long jr = bombs[j][2];
                // 这里防止溢出
                long diffx = ix - jx;
                long diffy = iy - jy;
                long dist = diffx * diffx + diffy * diffy;
                if (ir * ir >= dist) {
                    g[i].add(j);
                }
                if (jr * jr >= dist) {
                    g[j].add(i);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            res = Math.max(res, dfs(i, g, visited));
        }
        return res;
    }

    int dfs(int root, List<Integer>[] g, boolean[] visited) {
        visited[root] = true;
        int res = 1;
        for (Integer next : g[root]) {
            if (visited[next]) {
                continue;
            }
            res += dfs(next, g, visited);
        }
        return res;
    }

}
