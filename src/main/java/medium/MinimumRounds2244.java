package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 完成所有任务需要的最少轮数
 * <p>
 * 给你一个下标从 0 开始的整数数组 tasks ，其中 tasks[i] 表示任务的难度级别。
 * 在每一轮中，你可以完成 2 个或者 3 个 相同难度级别 的任务。
 * 返回完成所有任务需要的 最少 轮数，如果无法完成所有任务，返回 -1 。
 *
 * @author jd95288
 * @date 2024-05-14 0:11
 */
public class MinimumRounds2244 {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int t : tasks) {
            map.merge(t, 1, Integer::sum);
        }
        for (Integer cnt : map.values()) {
            if (cnt == 1) {
                return -1;
            } else if (cnt == 2 || cnt == 3) {
                res++;
            } else if (cnt % 3 == 0) {
                res += cnt / 3;
            } else if (cnt % 3 == 2) {
                res += (cnt - 2) / 3 + 1;
            } else if (cnt % 3 == 1) {
                res += (cnt - 4) / 3 + 2;
            }
        }
        return res;
    }
}
