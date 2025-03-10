package easy;

/**
 * 找到一个数字的 K 美丽值
 * <p>
 * 一个整数 num 的 k 美丽值定义为 num 中符合以下条件的 子字符串 数目：
 * 子字符串长度为 k 。
 * 子字符串能整除 num 。
 * <p>
 * 给你整数 num 和 k ，请你返回 num 的 k 美丽值。
 * <p>
 * 注意：
 * 允许有 前缀 0 。
 * 0 不能整除任何值。
 * <p>
 * 一个 子字符串 是一个字符串里的连续一段字符序列。
 *
 * @author jd95288
 * @date 2025-03-10 8:45
 */
public class DivisorSubstrings2269 {

    public int divisorSubstrings(int num, int k) {
        String s = String.valueOf(num);
        int n = s.length();
        int res = 0;
        for (int i = 0; i + k <= n; i++) {
            int subNum = Integer.parseInt(s.substring(i, i + k));
            if (subNum != 0 && num % subNum == 0) {
                res++;
            }
        }
        return res;
    }

}
