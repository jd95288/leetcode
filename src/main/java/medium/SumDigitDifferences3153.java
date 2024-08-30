package medium;

/**
 * 所有数对中数位不同之和
 * <p>
 * 你有一个数组 nums ，它只包含 正 整数，所有正整数的数位长度都 相同 。
 * 两个整数的 数位不同 指的是两个整数 相同 位置上不同数字的数目。
 * 请你返回 nums 中 所有 整数对里，数位不同之和。
 *
 * @author jd95288
 * @date 2024-08-30 9:33
 */
public class SumDigitDifferences3153 {

    public long sumDigitDifferences(int[] nums) {
        int n = nums.length;
        int first = nums[0];
        int digitsLength = 0;
        while (first > 0) {
            digitsLength++;
            first /= 10;
        }
        int[][] cnt = new int[digitsLength][10];
        for (int i = 0; i < n; i++) {
            int d = 0;
            int num = nums[i];
            while (num > 0) {
                cnt[d++][num % 10]++;
                num /= 10;
            }
        }
        long res = 0L;
        for (int[] digit : cnt) {
            for (int i = 0; i < 10; i++) {
                if (digit[i] == 0) {
                    continue;
                }
                for (int j = i + 1; j < 10; j++) {
                    res += (long) digit[i] * digit[j];
                }
            }
        }
        return res;
    }

}
