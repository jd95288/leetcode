package easy;

/**
 * 找到初始输入字符串 I
 *
 * Alice 正在她的电脑上输入一个字符串。但是她打字技术比较笨拙，她 可能 在一个按键上按太久，导致一个字符被输入 多次 。
 * 尽管 Alice 尽可能集中注意力，她仍然可能会犯错 至多 一次。
 * 给你一个字符串 word ，它表示 最终 显示在 Alice 显示屏上的结果。
 * 请你返回 Alice 一开始可能想要输入字符串的总方案数。
 *
 * @author jd95288
 * @date 2025-07-01 9:01
 */
public class PossibleStringCount3330 {

    public int possibleStringCount(String word) {
        int res = 0;
        int n = word.length();
        int l = 0, r = 0;
        while (r < n) {
            while (r < n && word.charAt(r) == word.charAt(l)) {
                r++;
            }
            res += r - l - 1;
            l = r;
        }
        return res + 1;
    }

}
