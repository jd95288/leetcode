package easy;

/**
 * 最大二进制奇数
 * 给你一个 二进制 字符串 s ，其中至少包含一个 '1' 。
 * 你必须按某种方式 重新排列 字符串中的位，使得到的二进制数字是可以由该组合生成的 最大二进制奇数 。
 * 以字符串形式，表示并返回可以由给定组合生成的最大二进制奇数。
 * 注意 返回的结果字符串 可以 含前导零。
 *
 * @author jd95288
 * @date 2024-03-13 0:18
 */
public class MaximumOddBinaryNumber {
    public String maximumOddBinaryNumber(String s) {
        char[] chars = s.toCharArray();
        int cnt = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (i != chars.length - 1 && chars[i] == '1') {
                cnt++;
                chars[i] = '0';
            } else if (i == chars.length - 1 && chars[i] == '0') {
                cnt--;
                chars[i] = '1';
            }
        }
        for (int i = 0; i < cnt; i++) {
            chars[i] = '1';
        }
        return new String(chars);
    }
}
