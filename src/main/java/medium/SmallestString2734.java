package medium;

/**
 * 执行子串操作后的字典序最小字符串
 * <p>
 * 给你一个仅由小写英文字母组成的字符串 s 。在一步操作中，你可以完成以下行为：
 * 选择 s 的任一非空子字符串，可能是整个字符串，接着将字符串中的每一个字符替换为英文字母表中的前一个字符。例如，'b' 用 'a' 替换，'a' 用 'z' 替换。
 * 返回执行上述操作 恰好一次 后可以获得的 字典序最小 的字符串。
 * 子字符串 是字符串中的一个连续字符序列。
 * 现有长度相同的两个字符串 x 和 字符串 y ，在满足 x[i] != y[i] 的第一个位置 i 上，如果  x[i] 在字母表中先于 y[i] 出现，则认为字符串 x 比字符串 y 字典序更小 。
 *
 * @author jd95288
 * @date 2024-06-27 0:05
 */
public class SmallestString2734 {

    /**
     * 执行通过，修改了全为a时的判断逻辑
     */
    public String smallestString(String s) {
        int i = 0;
        int n = s.length();
        char[] chars = s.toCharArray();
        while (i < n && chars[i] == 'a') {
            i++;
        }
        while (i < n && chars[i] != 'a') {
            chars[i++]--;
        }
        if (i == n && s.charAt(n - 1) == 'a') {
            chars[n - 1] = 'z';
        }
        return new String(chars);
    }

}
