package easy;

/**
 * 按键变更的次数
 * <p>
 * 给你一个下标从 0 开始的字符串 s ，该字符串由用户输入。按键变更的定义是：使用与上次使用的按键不同的键。
 * 例如 s = "ab" 表示按键变更一次，而 s = "bBBb" 不存在按键变更。
 * 返回用户输入过程中按键变更的次数。
 * 注意：shift 或 caps lock 等修饰键不计入按键变更，也就是说，
 * 如果用户先输入字母 'a' 然后输入字母 'A' ，不算作按键变更。
 *
 * @author jd95288
 * @date 2025-01-07 8:46
 */
public class CountKeyChanges3019 {

    public int countKeyChanges(String s) {
        int res = 0;
        int n = s.length();
        for (int i = 1; i < n; i++) {
            if ((s.charAt(i) | 32) != (s.charAt(i - 1) | 32)) {
                res++;
            }
        }
        return res;
    }

}
