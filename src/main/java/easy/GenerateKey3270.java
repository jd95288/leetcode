package easy;

/**
 * 求出数字答案
 * <p>
 * 给你三个 正 整数 num1 ，num2 和 num3 。
 * 数字 num1 ，num2 和 num3 的数字答案 key 是一个四位数，定义如下：
 * 一开始，如果有数字 少于 四位数，给它补 前导 0 。
 * 答案 key 的第 i 个数位（1 <= i <= 4）为 num1 ，num2 和 num3 第 i 个数位中的 最小 值。
 * 请你返回三个数字 没有 前导 0 的数字答案。
 *
 * @author jd95288
 * @date 2025-01-11 16:55
 */
public class GenerateKey3270 {

    public int generateKey(int num1, int num2, int num3) {
        int res = 0;
        int base = 1000;
        for (int i = 0; i < 4; i++) {
            int a1 = num1 / base;
            int a2 = num2 / base;
            int a3 = num3 / base;
            res += Math.min(a1, Math.min(a2, a3)) * base;
            num1 %= base;
            num2 %= base;
            num3 %= base;
            base /= 10;
        }
        return res;
    }
}
