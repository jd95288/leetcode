package hard;

import java.util.Arrays;

/**
 * 完成所有交易的初始最少钱数
 * <p>
 * 给你一个下标从 0 开始的二维整数数组 transactions，其中transactions[i] = [costi, cashbacki] 。
 * 数组描述了若干笔交易。其中每笔交易必须以 某种顺序 恰好完成一次。
 * 在任意一个时刻，你有一定数目的钱 money ，为了完成交易 i ，money >= costi 这个条件必须为真。
 * 执行交易后，你的钱数 money 变成 money - costi + cashbacki 。
 * 请你返回 任意一种 交易顺序下，你都能完成所有交易的最少钱数 money 是多少。
 *
 * @author jd95288
 * @date 2025-01-25 20:42
 */
public class MinimumMoney2412 {

    public long minimumMoney(int[][] transactions) {
        Arrays.sort(transactions, (a, b) -> {
            int diffa = a[1] - a[0];
            int diffb = b[1] - b[0];
            return diffa - diffb;
        });
        int cut = 0;
        for (int[] transaction : transactions) {
            if (transaction[0] <= transaction[1]) {
                break;
            }
            cut++;
        }
        int n = transactions.length;
        int[][] a = new int[cut][];
        int[][] b = new int[n - cut][];
        System.arraycopy(transactions, 0, a, 0, cut);
        System.arraycopy(transactions, cut, b, 0, n - cut);
        Arrays.sort(a, (x, y) -> x[1] - y[1]);
        Arrays.sort(b, (x, y) -> y[0] - x[0]);
        long res = 0;
        long remainder = 0;
        for (int[] item : a) {
            if (remainder < item[0]) {
                res += item[0] - remainder;
            }
            remainder = item[1];
        }
        if (b.length > 0 && remainder < b[0][0]) {
            res += b[0][0] - remainder;
        }
        return res;
    }

}
