package easy;

/**
 * 分类求和并作差
 * <p>
 * 给你两个正整数 n 和 m 。
 * 现定义两个整数 num1 和 num2 ，如下所示：
 * num1：范围 [1, n] 内所有 无法被 m 整除 的整数之和。
 * num2：范围 [1, n] 内所有 能够被 m 整除 的整数之和。
 * 返回整数 num1 - num2 。
 *
 * @author jd95288
 * @date 2025-05-27 1:00
 */
public class DifferenceOfSums2894 {

    public int differenceOfSums(int n, int m) {
        int num1 = 0;
        int num2 = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                num2 += i;
            } else {
                num1 += i;
            }
        }
        return num1 - num2;
    }
}
