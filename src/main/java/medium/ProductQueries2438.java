package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 二的幂数组中查询范围内的乘积
 * <p>
 * 给你一个正整数 n ，你需要找到一个下标从 0 开始的数组 powers ，它包含 最少 数目的 2 的幂，且它们的和为 n 。
 * powers 数组是 非递减 顺序的。根据前面描述，构造 powers 数组的方法是唯一的。
 * 同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] ，
 * 其中 queries[i] 表示请你求出满足 lefti <= j <= righti 的所有 powers[j] 的乘积。
 * 请你返回一个数组 answers ，长度与 queries 的长度相同，其中 answers[i]是第 i 个查询的答案。
 * 由于查询的结果可能非常大，请你将每个 answers[i] 都对 10^9 + 7 取余 。
 *
 * @author jd95288
 * @date 2025-08-11 9:52
 */
public class ProductQueries2438 {

    public int[] productQueries(int n, int[][] queries) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            int p = 1 << i;
            if ((n & p) == p) {
                list.add(p);
            }
        }
        int mod = 1000000007;
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            res[i] = 1;
            for (int j = from; j <= to; j++) {
                res[i] = (int) ((long) res[i] * list.get(j) % mod);
            }
        }
        return res;
    }

}
