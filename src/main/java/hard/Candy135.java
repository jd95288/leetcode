package hard;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 分发糖果
 * <p>
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * 你需要按照以下要求，给这些孩子分发糖果：
 * - 每个孩子至少分配到 1 个糖果。
 * - 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 *
 * @author jd95288
 * @date 2024-12-11 9:18
 */
public class Candy135 {

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] cnt = new int[n];
        cnt[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                cnt[i] = cnt[i - 1] + 1;
            } else {
                cnt[i] = 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                cnt[i] = Math.max(cnt[i], cnt[i + 1] + 1);
            }
        }
        return Arrays.stream(cnt).sum();
    }
}
