package easy;

/**
 * 交换后字典序最小的字符串
 * <p>
 * 给你一个仅由数字组成的字符串 s，在最多交换一次 相邻 且具有相同 奇偶性 的数字后，返回可以得到的字典序最小的字符串。
 * 如果两个数字都是奇数或都是偶数，则它们具有相同的奇偶性。例如，5 和 9、2 和 4 奇偶性相同，而 6 和 9 奇偶性不同。
 *
 * @author jd95288
 * @date 2024-10-30 0:11
 */
public class GetSmallestString3216 {

    public String getSmallestString(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int prev = s.charAt(0);
        for (int i = 1; i < n; i++) {
            int cur = s.charAt(i);
            if (prev > cur && prev % 2 == cur % 2) {
                chars[i] = s.charAt(i - 1);
                chars[i - 1] = s.charAt(i);
                break;
            }
            prev = cur;
        }
        return new String(chars);
    }

}
