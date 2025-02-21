package easy;

/**
 * 奇偶位数
 *
 * 给你一个 正 整数 n 。
 * 用 even 表示在 n 的二进制形式（下标从 0 开始）中值为 1 的偶数下标的个数。
 * 用 odd 表示在 n 的二进制形式（下标从 0 开始）中值为 1 的奇数下标的个数。
 * 返回整数数组 answer ，其中 answer = [even, odd] 。
 *
 * @author jd95288
 * @date 2025-02-20 8:39
 */
public class EvenOddBit2595 {

    public int[] evenOddBit_v1(int n) {
        int even = 0;
        int odd = 0;
        while (n > 0) {
            even += n & 1;
            n >>= 1;
            odd += n & 1;
            n >>= 1;
        }
        return new int[]{even, odd};
    }

}
