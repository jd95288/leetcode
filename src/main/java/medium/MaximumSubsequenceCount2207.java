package medium;

/**
 * 字符串中最多数目的子序列
 * <p>
 * 给你一个下标从 0 开始的字符串 text 和另一个下标从 0 开始且长度为 2 的字符串 pattern ，两者都只包含小写英文字母。
 * 你可以在 text 中任意位置插入 一个 字符，这个插入的字符必须是 pattern[0] 或者 pattern[1] 。
 * 注意，这个字符可以插入在 text 开头或者结尾的位置。
 * 请你返回插入一个字符后，text 中最多包含多少个等于 pattern 的 子序列 。
 * 子序列 指的是将一个字符串删除若干个字符后（也可以不删除），剩余字符保持原本顺序得到的字符串。
 *
 * @author jd95288
 * @date 2024-09-24 8:54
 */
public class MaximumSubsequenceCount2207 {

    public long maximumSubsequenceCount(String text, String pattern) {
        long cnt1 = 0, cnt2 = 0;
        char c1 = pattern.charAt(0), c2 = pattern.charAt(1);
        char[] chars = text.toCharArray();
        long sub = 0;
        for (char c : chars) {
            if (c1 == c) {
                cnt1++;
                sub += cnt2;
            } else if (c2 == c) {
                cnt2++;
            }
        }
        if (c1 == c2) {
            return cnt1 * (cnt1 + 1) / 2;
        }
        return Math.max(cnt1, cnt2) * (Math.min(cnt1, cnt2) + 1) - sub;
    }

}
