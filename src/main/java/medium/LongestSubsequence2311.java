package medium;

/**
 * 小于等于 K 的最长二进制子序列
 * <p>
 * 给你一个二进制字符串 s 和一个正整数 k 。
 * 请你返回 s 的 最长 子序列的长度，且该子序列对应的 二进制 数字小于等于 k 。
 * 注意：
 * 子序列可以有 前导 0 。
 * 空字符串视为 0 。
 * 子序列 是指从一个字符串中删除零个或者多个字符后，不改变顺序得到的剩余字符序列。
 *
 * @author jd95288
 * @date 2025-06-26 8:47
 */
public class LongestSubsequence2311 {

    public int longestSubsequence(String s, int k) {
        int res = 0;
        s = "0" + s;
        int n = s.length();
        long base = 2;
        long v = s.charAt(n - 1) - '0';
        for (int i = n - 1; i > 0; i--) {
            if (v <= k) {
                res++;
                v += base * (s.charAt(i - 1) - '0');
                if (base <= k) {
                    base *= 2;
                }
            } else if (s.charAt(i) == '0') {
                res++;
            }
        }
        return res;
    }

}
