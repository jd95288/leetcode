package medium;

/**
 * 判断一个括号字符串是否有效
 * <p>
 * 一个括号字符串是只由 '(' 和 ')' 组成的 非空 字符串。如果一个字符串满足下面 任意 一个条件，那么它就是有效的：
 * 字符串为 ().
 * 它可以表示为 AB（A 与 B 连接），其中A 和 B 都是有效括号字符串。
 * 它可以表示为 (A) ，其中 A 是一个有效括号字符串。
 * <p>
 * 给你一个括号字符串 s 和一个字符串 locked ，两者长度都为 n 。locked 是一个二进制字符串，只包含 '0' 和 '1' 。对于 locked 中 每一个 下标 i ：
 * 如果 locked[i] 是 '1' ，你 不能 改变 s[i] 。
 * 如果 locked[i] 是 '0' ，你 可以 将 s[i] 变为 '(' 或者 ')' 。
 * <p>
 * 如果你可以将 s 变为有效括号字符串，请你返回 true ，否则返回 false 。
 *
 * @author jd95288
 * @date 2025-03-23 21:12
 */
public class CanBeValid2116 {

    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        int max = 0, min = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0') {
                max++;
                if (--min < 0) {
                    min = 1;
                }
                continue;
            }
            if ('(' == chars[i]) {
                max++;
                min++;
            } else {
                if (--max < 0) {
                    return false;
                }
                if (--min < 0) {
                    min = 1;
                }
            }
        }
        return min == 0;
    }
}
