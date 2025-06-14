package easy;

/**
 * 替换一个数字后的最大差值
 *
 * 给你一个整数 num 。你知道 Bob  会偷偷将 0 到 9 中的一个数字 替换 成另一个数字。
 * 请你返回将 num 中 恰好一个 数字进行替换后，得到的最大值和最小值的差为多少。
 * 注意：
 * 当 Bob 将一个数字 d1 替换成另一个数字 d2 时，Bob 需要将 nums 中所有 d1 都替换成 d2 。
 * Bob 可以将一个数字替换成它自己，也就是说 num 可以不变。
 * Bob 可以将数字分别替换成两个不同的数字分别得到最大值和最小值。
 * 替换后得到的数字可以包含前导 0 。
 * Bob 获得周赛 326 前 10 名，让我们恭喜他。
 *
 * @author jd95288
 * @date 2025-06-14 9:49
 */
public class MinMaxDifference2566 {

    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        int n = s.length();
        int mul = (int) Math.pow(10, n - 1);
        int max = num, min = num;
        char maxReplace = '-';
        char minReplace = chars[0];
        for (int i = 0; i < n; i++) {
            if (maxReplace == '-' && chars[i] != '9') {
                maxReplace = chars[i];
            }
            if (minReplace == chars[i]) {
                min -= mul * (chars[i] - '0');
            }
            if (maxReplace == chars[i]) {
                max += mul * (9 - (chars[i] - '0'));
            }
            mul /= 10;
        }
        return max - min;
    }

}
