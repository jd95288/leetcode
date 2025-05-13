package medium;

/**
 * 字符串转换后的长度 I
 * <p>
 * 给你一个字符串 s 和一个整数 t，表示要执行的 转换 次数。每次 转换 需要根据以下规则替换字符串 s 中的每个字符：
 * 如果字符是 'z'，则将其替换为字符串 "ab"。
 * 否则，将其替换为字母表中的下一个字符。例如，'a' 替换为 'b'，'b' 替换为 'c'，依此类推。
 * 返回 恰好 执行 t 次转换后得到的字符串的 长度。
 * 由于答案可能非常大，返回其对 10^9 + 7 取余的结果。
 *
 * @author jd95288
 * @date 2025-05-13 0:07
 */
public class LengthAfterTransformations3335 {

    public int lengthAfterTransformations(String s, int t) {
        int[] cnt = new int[26];
        int mod = 1000000007;
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (int i = 0; i < t; i++) {
            int prev = cnt[0];
            for (int j = 1; j < 26; j++) {
                int tmp = cnt[j];
                cnt[j] = prev;
                prev = tmp;
            }
            cnt[0] = prev;
            cnt[1] = (cnt[1] + prev) % mod;
        }
        int res = 0;
        for (int num : cnt) {
            res = (res + num) % mod;
        }
        return res;
    }

}
