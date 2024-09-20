package medium;

/**
 * 最长的字母序连续子字符串的长度
 *
 * 字母序连续字符串 是由字母表中连续字母组成的字符串。
 * 换句话说，字符串 "abcdefghijklmnopqrstuvwxyz" 的任意子字符串都是 字母序连续字符串 。
 * 例如，"abc" 是一个字母序连续字符串，而 "acb" 和 "za" 不是。
 * 给你一个仅由小写英文字母组成的字符串 s ，返回其 最长 的 字母序连续子字符串 的长度。
 *
 * @author jd95288
 * @date 2024-09-19 13:48
 */
public class LongestContinuousSubstring2414 {

    public int longestContinuousSubstring(String s) {
        int n = s.length();
        int res = 0;
        int cnt = 0;
        int last = s.charAt(0) - 1;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c - last == 1) {
                res = Math.max(res, ++cnt);
            } else {
                cnt = 1;
            }
            last = c;
        }
        return res;
    }

}
