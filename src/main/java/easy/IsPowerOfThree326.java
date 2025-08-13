package easy;

/**
 * 3 的幂
 * <p>
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3^x
 *
 * @author jd95288
 * @date 2025-08-13 8:40
 */
public class IsPowerOfThree326 {

    public boolean isPowerOfThree(int n) {
        int base = 3;
        long num = 1;
        while (num <= n) {
            if (num == n) {
                return true;
            }
            num *= base;
        }
        return false;
    }

}
