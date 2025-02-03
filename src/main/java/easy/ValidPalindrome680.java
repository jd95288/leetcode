package easy;


/**
 * 验证回文串 II
 *
 * 给你一个字符串 s，最多 可以从中删除一个字符。
 * 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
 *
 * @author jd95288
 * @date 2025-02-03 18:24
 */
public class ValidPalindrome680 {

    public boolean validPalindrome(String s) {
        int n = s.length();
        int i = 0;
        for (; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                break;
            }
        }
        if (i == n / 2) {
            return true;
        }
        boolean res = true;
        for (int j = i; j < n / 2; j++) {
            if (s.charAt(j) != s.charAt(n - 2 - j)) {
                res = false;
            }
        }
        if (res) {
            return true;
        }
        for (int j = i + 1; j <= n / 2; j++) {
            if (s.charAt(j) != s.charAt(n - j)) {
                return false;
            }
        }
        return true;
    }

}
