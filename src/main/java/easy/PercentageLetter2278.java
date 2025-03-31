package easy;

/**
 * 字母在字符串中的百分比
 *
 * 给你一个字符串 s 和一个字符 letter ，返回在 s 中等于 letter 字符所占的 百分比 ，向下取整到最接近的百分比。
 *
 * @author jd95288
 * @date 2025-03-31 8:43
 */
public class PercentageLetter2278 {

    public int percentageLetter(String s, char letter) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == letter) {
                res++;
            }
        }
        return res * 100 / n;
    }
}
