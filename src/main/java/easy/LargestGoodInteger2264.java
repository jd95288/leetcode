package easy;

/**
 * 字符串中最大的3位相同数字
 * <p>
 * 给你一个字符串 num ，表示一个大整数。如果一个整数满足下述所有条件，则认为该整数是一个 优质整数 ：
 * - 该整数是 num 的一个长度为 3 的 子字符串 。
 * - 该整数由唯一一个数字重复 3 次组成。
 * 以字符串形式返回 最大的优质整数 。如果不存在满足要求的整数，则返回一个空字符串 "" 。
 * 注意：
 * - 子字符串 是字符串中的一个连续字符序列。
 * - num 或优质整数中可能存在 前导零 。
 *
 * @author jd95288
 * @date 2025-01-08 8:48
 */
public class LargestGoodInteger2264 {

    public String largestGoodInteger(String num) {
        char c = 0;
        int n = num.length();
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (num.charAt(i) == num.charAt(i - 1)) {
                cnt++;
            } else {
                cnt = 1;
                continue;
            }
            if (cnt == 3 && c < num.charAt(i)) {
                c = num.charAt(i);
            }
        }
        return c > 0 ? new String(new char[]{c, c, c}) : "";
    }

}
