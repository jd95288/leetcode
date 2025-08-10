package medium;


/**
 * 重新排序得到 2 的幂
 * <p>
 * 给定正整数 n ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
 *
 * @author jd95288
 * @date 2025-08-10 13:49
 */
public class ReorderedPowerOf2_869 {

    public static int[][] nums = new int[31][10];

    static {
        for (int i = 0; i < 31; i++) {
            int num = 1 << i;
            while (num > 0) {
                int d = num % 10;
                nums[i][d]++;
                num /= 10;
            }
        }
    }

    public boolean reorderedPowerOf2(int n) {
        int[] digits = new int[10];
        while (n > 0) {
            int d = n % 10;
            digits[d]++;
            n /= 10;
        }
        here:
        for (int[] num : nums) {
            for (int i = 0; i < num.length; i++) {
                if (num[i] != digits[i]) {
                    continue here;
                }
            }
            return true;
        }
        return false;
    }

}
