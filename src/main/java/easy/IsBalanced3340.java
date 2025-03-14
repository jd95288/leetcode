package easy;

/**
 * 检查平衡字符串
 * <p>
 * 给你一个仅由数字 0 - 9 组成的字符串 num。如果偶数下标处的数字之和等于奇数下标处的数字之和，则认为该数字字符串是一个 平衡字符串。
 * 如果 num 是一个 平衡字符串，则返回 true；否则，返回 false。
 *
 * @author jd95288
 * @date 2025-03-14 0:36
 */
public class IsBalanced3340 {

    public boolean isBalanced(String num) {
        int n = num.length();
        int sum = 0;
        for (int i = 0; i < n; i += 2) {
            sum += num.charAt(i) - '0';
        }
        for (int i = 1; i < n; i += 2) {
            sum -= num.charAt(i) - '0';
        }
        return sum == 0;
    }

}
