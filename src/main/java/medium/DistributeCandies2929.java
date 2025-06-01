package medium;


/**
 * 给小朋友们分糖果 II
 * <p>
 * 给你两个正整数 n 和 limit 。
 * 请你将 n 颗糖果分给 3 位小朋友，确保没有任何小朋友得到超过 limit 颗糖果，请你返回满足此条件下的 总方案数 。
 *
 * @author jd95288
 * @date 2025-06-01 21:49
 */
public class DistributeCandies2929 {

    public long distributeCandies(int n, int limit) {
        long res = 0L;
        for (int i = 0; i <= Math.min(n, limit); i++) {
            if (n - i > 2 * limit) {
                continue;
            }
            res += Math.min(n - i, limit) - Math.max(0, n - i - limit) + 1;
        }
        return res;
    }
}
