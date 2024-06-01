package easy;

/**
 * 给小朋友们分糖果 I
 * <p>
 * 给你两个正整数 n 和 limit 。
 * 请你将 n 颗糖果分给 3 位小朋友，确保没有任何小朋友得到超过 limit 颗糖果，请你返回满足此条件下的 总方案数 。
 *
 * @author jd95288
 * @date 2024-06-01 15:59
 */
public class DistributeCandies2928 {
    public int distributeCandies(int n, int limit) {
        int res = 0;
        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j <= Math.min(limit, n - i); j++) {
                if(n - i - j <= limit){
                    res++;
                }
            }
        }
        return res;
    }
}
