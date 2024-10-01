package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 最低票价
 * <p>
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。
 * 在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
 * 火车票有 三种不同的销售方式 ：
 * 一张 为期一天 的通行证售价为 costs[0] 美元；
 * 一张 为期七天 的通行证售价为 costs[1] 美元；
 * 一张 为期三十天 的通行证售价为 costs[2] 美元。
 * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张 为期 7 天 的通行证，
 * 那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 * 返回 你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费 。
 *
 * @author jd95288
 * @date 2024-10-01 20:43
 */
public class MincostTickets983 {

    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int end = days[n - 1];
        int[] dp = new int[end + 1];
        int last = 0;
        int index = 0;
        Set<Integer> set = new HashSet<>(n);
        for (int day : days) {
            set.add(day);
            while (index < day) {
                dp[index++] = last;
            }
            dp[day] += last + costs[0];
            last = dp[day];
        }
        for (int i = 1; i <= end; i++) {
            int tmp7 = Math.max(0, i - 7);
            int tmp30 = Math.max(0, i - 30);
            if (!set.contains(i)) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.min(dp[i - 1] + costs[0], dp[tmp7] + costs[1]);
                dp[i] = Math.min(dp[i], dp[tmp30] + costs[2]);
            }
        }
        return dp[end];
    }

}
