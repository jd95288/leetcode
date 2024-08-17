package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * K 周期字符串需要的最少操作次数
 * <p>
 * 给你一个长度为 n 的字符串 word 和一个整数 k ，其中 k 是 n 的因数。
 * 在一次操作中，你可以选择任意两个下标 i 和 j，其中 0 <= i, j < n ，
 * 且这两个下标都可以被 k 整除，然后用从 j 开始的长度为 k 的子串替换从 i 开始的长度为 k 的子串。
 * 也就是说，将子串 word[i..i + k - 1] 替换为子串 word[j..j + k - 1] 。
 * 返回使 word 成为 K 周期字符串 所需的 最少 操作次数。
 * 如果存在某个长度为 k 的字符串 s，使得 word 可以表示为任意次数连接 s ，
 * 则称字符串 word 是 K 周期字符串 。例如，如果 word == "ababab"，那么 word 就是 s = "ab" 时的 2 周期字符串 。
 *
 * @author jd95288
 * @date 2024-08-17 20:44
 */
public class MinimumOperationsToMakeKPeriodic3137 {


    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        int n = word.length();
        int max = 0;
        int parties = n / k;
        Map<String, Integer> map = new HashMap<>(parties);
        for (int i = k; i <= n; i += k) {
            String period = word.substring(i - k, i);
            int cnt = map.merge(period, 1, Integer::sum);
            max = Math.max(cnt, max);
        }
        return parties - max;
    }

}
