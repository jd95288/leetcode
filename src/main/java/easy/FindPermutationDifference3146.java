package easy;

/**
 * 两个字符串的排列差
 * <p>
 * 给你两个字符串 s 和 t，每个字符串中的字符都不重复，且 t 是 s 的一个排列。
 * 排列差 定义为 s 和 t 中每个字符在两个字符串中位置的绝对差值之和。
 * 返回 s 和 t 之间的 排列差 。
 *
 * @author jd95288
 * @date 2024-08-24 15:01
 */
public class FindPermutationDifference3146 {

    public int findPermutationDifference(String s, String t) {
        int res = 0;
        int[] pos = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            pos[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < n; i++) {
            res += Math.abs(pos[t.charAt(i) - 'a'] - i);
        }
        return res;
    }
}
