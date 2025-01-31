package easy;

/**
 * 反转字符串 II
 * <p>
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * @author jd95288
 * @date 2025-01-31 14:45
 */
public class ReverseStr541 {

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int k2 = 2 * k;
        int n = chars.length;
        for (int i = 0; i < n; i += k2) {
            int end = Math.min(i + k, n) - 1;
            reverse(chars, i, end);
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int end) {
        for (int j = i; j < end; j++) {
            char tmp = chars[j];
            chars[j] = chars[end];
            chars[end--] = tmp;
        }
    }

}
