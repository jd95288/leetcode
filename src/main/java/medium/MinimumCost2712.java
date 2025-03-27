package medium;

/**
 * 使所有字符相等的最小成本
 * <p>
 * 给你一个下标从 0 开始、长度为 n 的二进制字符串 s ，你可以对其执行两种操作：
 * 选中一个下标 i 并且反转从下标 0 到下标 i（包括下标 0 和下标 i ）的所有字符，成本为 i + 1 。
 * 选中一个下标 i 并且反转从下标 i 到下标 n - 1（包括下标 i 和下标 n - 1 ）的所有字符，成本为 n - i 。
 * 返回使字符串内所有字符 相等 需要的 最小成本 。
 * 反转 字符意味着：如果原来的值是 '0' ，则反转后值变为 '1' ，反之亦然。
 *
 * @author jd95288
 * @date 2025-03-27 1:33
 */
public class MinimumCost2712 {

    public long minimumCost(String s) {
        int n = s.length();
        long res = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                // 注意第一个参数不是 i + 1
                // i 表示反转 0 ~ i - 1，n - i 表示反转 i ~ n - 1
                res += Math.min(i, n - i);
            }
        }
        return res;
    }
}
