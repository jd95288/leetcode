package easy;

/**
 * 字符串的分数
 *
 * 给你一个字符串 s 。一个字符串的 分数 定义为相邻字符 ASCII 码差值绝对值的和。
 * 请你返回 s 的 分数 。
 *
 * @author jd95288
 * @date 2025-03-15 20:02
 */
public class ScoreOfString3110 {

    public int scoreOfString(String s) {
        int res = 0;
        int n = s.length();
        for (int i = 1; i < n; i++) {
            res += Math.abs(s.charAt(i) - s.charAt(i - 1));
        }
        return res;
    }
}
