package easy;

/**
 * 统计桌面上的不同数字
 * 给你一个正整数 n ，开始时，它放在桌面上。在 10^9 天内，每天都要执行下述步骤：
 * 对于出现在桌面上的每个数字 x ，找出符合 1 <= i <= n 且满足 x % i == 1 的所有数字 i 。
 * 然后，将这些数字放在桌面上。
 * 返回在 10^9 天之后，出现在桌面上的 不同 整数的数目。
 *
 * @author jd95288
 * @date 2024-03-23 21:18
 */
public class DistinctIntegers {
    public int distinctIntegers(int n) {
        return n == 1 ? 1 : n - 1;
    }
}
