package medium;

import java.util.*;

/**
 * 安排工作以达到最大收益
 * <p>
 * 你有 n 个工作和 m 个工人。给定三个数组： difficulty, profit 和 worker ，其中:
 * <p>
 * difficulty[i] 表示第 i 个工作的难度，profit[i] 表示第 i 个工作的收益。
 * worker[i] 是第 i 个工人的能力，即该工人只能完成难度小于等于 worker[i] 的工作。
 * 每个工人 最多 只能安排 一个 工作，但是一个工作可以 完成多次 。
 * <p>
 * 举个例子，如果 3 个工人都尝试完成一份报酬为 $1 的同样工作，那么总收益为 $3 。
 * 如果一个工人不能完成任何工作，他的收益为 $0 。
 * 返回 在把工人分配到工作岗位后，我们所能获得的最大利润 。
 *
 * @author jd95288
 * @date 2024-05-17 9:20
 */
public class MaxProfitAssignment826 {

    public static class Point{
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int res = 0;
        int n = difficulty.length;
        Point[] jobs = new Point[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Point(difficulty[i], profit[i]);
        }
        Arrays.sort(jobs, (a, b) -> a.x - b.x);
        // 根据工人技能排序
        // 越往后能力越高，可以直接接着上一次难度位置向后遍历
        Arrays.sort(worker);
        int index = 0;
        int best = 0;
        for (int capability : worker) {
            while (index < n && capability >= jobs[index].x) {
                best = Math.max(best, jobs[index++].y);
            }
            res += best;
        }
        return res;
    }

}
