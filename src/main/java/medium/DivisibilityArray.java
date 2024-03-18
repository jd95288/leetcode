package medium;

/**
 * 找出字符串的可整除数组
 * 给你一个下标从 0 开始的字符串 word ，长度为 n ，由从 0 到 9 的数字组成。另给你一个正整数 m 。
 * word 的 可整除数组 div  是一个长度为 n 的整数数组，并满足：
 * 如果 word[0,...,i] 所表示的 数值 能被 m 整除，div[i] = 1
 * 否则，div[i] = 0
 * 返回 word 的可整除数组。
 *
 * @author jd95288
 * @date 2024-03-07 9:27
 */
public class DivisibilityArray {

    public int[] divisibilityArray(String word, int m) {
        long remainder = 0;
        int n = word.length();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            remainder = (remainder * 10 + (word.charAt(i) - '0')) % m;
            if (remainder == 0) {
                res[i] = 1;
            }
        }
        return res;
    }

}
