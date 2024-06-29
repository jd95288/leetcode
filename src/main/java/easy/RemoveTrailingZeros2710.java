package easy;

/**
 * 移除字符串中的尾随零
 * <p>
 * 给你一个用字符串表示的正整数 num ，请你以字符串形式返回不含尾随零的整数 num 。
 *
 * @author jd95288
 * @date 2024-06-29 21:45
 */
public class RemoveTrailingZeros2710 {

    public String removeTrailingZeros(String num) {
        int n = num.length() - 1;
        while (n >= 0 && num.charAt(n) == '0') {
            n--;
        }
        return num.substring(0, n + 1);
    }

}
