package easy;

/**
 * 统计最大组的数目
 * <p>
 * 给你一个整数 n 。请你先求出从 1 到 n 的每个整数 10 进制表示下的数位和（每一位上的数字相加），然后把数位和相等的数字放到同一个组中。
 * 请你统计每个组中的数字数目，并返回数字数目并列最多的组有多少个。
 *
 * @author jd95288
 * @date 2025-04-23 0:12
 */
public class CountLargestGroup1399 {

    public int countLargestGroup(int n) {
        int length = String.valueOf(n).length();
        int[] cnt = new int[9 * length + 1];
        int maxDigitSumCnt = 0;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            if (maxDigitSumCnt < ++cnt[sum]) {
                maxDigitSumCnt = cnt[sum];
                res = 1;
            } else if (maxDigitSumCnt == cnt[sum]) {
                res++;
            }
        }
        return res;
    }

}
