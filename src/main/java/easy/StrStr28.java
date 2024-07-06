package easy;

/**
 * 找出字符串中第一个匹配项的下标
 * <p>
 * 给你两个字符串 haystack 和 needle ，
 * 请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 *
 * @author jd95288
 * @date 2024-07-06 22:01
 */
public class StrStr28 {

    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int k = needle.length();
        for (int i = 0; i < n; i++) {
            int p = 0;
            int s = i;
            while (p < k && s < n && haystack.charAt(s) == needle.charAt(p)) {
                p++;
                s++;
            }
            if (p == k) {
                return i;
            }
        }
        return -1;
    }

}
