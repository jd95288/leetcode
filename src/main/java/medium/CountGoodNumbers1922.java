package medium;

/**
 * 统计好数字的数目
 * <p>
 * 我们称一个数字字符串是 好数字 当它满足（下标从 0 开始）偶数 下标处的数字为 偶数 且 奇数 下标处的数字为 质数 （2，3，5 或 7）。
 * 比方说，"2582" 是好数字，因为偶数下标处的数字（2 和 8）是偶数且奇数下标处的数字（5 和 2）为质数。但 "3245" 不是 好数字，因为 3 在偶数下标处但不是偶数。
 * 给你一个整数 n ，请你返回长度为 n 且为好数字的数字字符串 总数 。由于答案可能会很大，请你将它对 10^9 + 7 取余后返回 。
 * 一个 数字字符串 是每一位都由 0 到 9 组成的字符串，且可能包含前导 0 。
 *
 * @author jd95288
 * @date 2025-04-13 0:43
 */
public class CountGoodNumbers1922 {

    private static final int MOD = 1000000007;

    public int countGoodNumbers(long n) {
        if (n == 1) {
            return 5;
        }
        return (int) ((pow(5, n / 2 + n % 2) * pow(4, n / 2)) % MOD);
    }

    public long pow(int base, long power) {
        long res = 1L;
        while (power > 0) {
            if ((power & 1) == 1) {
                res = (int) (base * res % MOD);
            }
            base = (int) (((long) base * base) % MOD);
            power >>= 1;
        }
        return res;
    }

}
