package medium;

/**
 * 满足距离约束且字典序最小的字符串
 * <p>
 * 给你一个字符串 s 和一个整数 k 。
 * 定义函数 distance(s1, s2) ，用于衡量两个长度为 n 的字符串 s1 和 s2 之间的距离，即：
 * 字符 'a' 到 'z' 按 循环 顺序排列，对于区间 [0, n - 1] 中的 i ，计算所有「 s1[i] 和 s2[i] 之间 最小距离」的 和 。
 * 例如，distance("ab", "cd") == 4 ，且 distance("a", "z") == 1 。
 * 你可以对字符串 s 执行 任意次 操作。在每次操作中，可以将 s 中的一个字母 改变 为 任意 其他小写英文字母。
 * 返回一个字符串，表示在执行一些操作后你可以得到的 字典序最小 的字符串 t ，且满足 distance(s, t) <= k 。
 *
 * @author jd95288
 * @date 2024-07-27 22:22
 */
public class GetSmallestString3106 {

    public String getSmallestString(String s, int k) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int i = 0;
        while (k > 0 && i < n) {
            char c = chars[i];
            int dist = Math.min('z' - c + 1, c - 'a');
            if (k < dist) {
                chars[i] -= k;
                break;
            }
            chars[i] = 'a';
            k -= dist;
            i++;
        }

        return new String(chars);
    }
}
