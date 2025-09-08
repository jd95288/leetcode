package easy;


/**
 * 将整数转换为两个无零整数的和
 * <p>
 * 「无零整数」是十进制表示中 不含任何 0 的正整数。
 * 给你一个整数 n，请你返回一个 由两个整数组成的列表 [a, b]，满足：
 * a 和 b 都是无零整数
 * a + b = n
 * 题目数据保证至少有一个有效的解决方案。
 * 如果存在多个有效解决方案，你可以返回其中任意一个。
 *
 * @author jd95288
 * @date 2025-09-08 8:50
 */
public class GetNoZeroIntegers1317 {

    public int[] getNoZeroIntegers(int n) {
        int a = 0, b = 0;
        int base = 1;
        while (n > 0) {
            int r = n % 10;
            n /= 10;
            if (r > 1) {
                a += base;
                b += (r - 1) * base;
            } else if (n == 0) {
                a += base;
            } else {
                r += 10;
                a += 2 * base;
                b += (r - 2) * base;
                n--;
            }
            base *= 10;
        }
        return new int[]{a, b};
    }

}
