package easy;

/**
 * 检测大写字母
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * 全部字母都是大写，比如 "USA" 。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 *
 * @author jd95288
 * @date 2024-06-23 19:05
 */
public class DetectCapitalUse520 {

    public boolean detectCapitalUse(String word) {
        int n = word.length();
        if (n == 1) {
            return true;
        }
        char f = word.charAt(0);
        boolean firstUpperCase = f >= 'A' && f <= 'Z';
        char s = word.charAt(1);
        boolean upperCase = s >= 'A' && s <= 'Z';
        if (!firstUpperCase && upperCase) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            char c = word.charAt(i);
            if ((upperCase && (c < 'A' || c > 'Z')) || (!upperCase && c >= 'A' && c <= 'Z')) {
                return false;
            }
        }
        return true;
    }
}
