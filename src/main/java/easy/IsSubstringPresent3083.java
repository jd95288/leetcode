package easy;


/**
 * 字符串及其反转中是否存在同一子字符串
 * <p>
 * 给你一个字符串 s ，请你判断字符串 s 是否存在一个长度为 2 的子字符串，在其反转后的字符串中也出现。
 * 如果存在这样的子字符串，返回 true；如果不存在，返回 false 。
 *
 * @author jd95288
 * @date 2024-12-26 8:47
 */
public class IsSubstringPresent3083 {

    public boolean isSubstringPresent(String s) {
        int n = s.length();
        int[] exists = new int[26];
        for (int i = 0; i < n - 1; i++) {
            int a = s.charAt(i) - 'a';
            int b = s.charAt(i + 1) - 'a';
            exists[a] |= 1 << b;
            if ((exists[b] >> a & 1) == 1) {
                return true;
            }
        }
        return false;
    }

}
