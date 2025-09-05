package medium;

/**
 * 得到整数零需要执行的最少操作数
 * <p>
 * 给你两个整数：num1 和 num2 。
 * 在一步操作中，你需要从范围 [0, 60] 中选出一个整数 i ，并从 num1 减去 2^i + num2 。
 * 请你计算，要想使 num1 等于 0 需要执行的最少操作数，并以整数形式返回。
 * 如果无法使 num1 等于 0 ，返回 -1 。
 *
 * @author jd95288
 * @date 2025-09-05 8:46
 */
public class MakeTheIntegerZero2749 {

    public int makeTheIntegerZero(int num1, int num2) {
        for (int i = 0; i < 61; i++) {
            long num = num1 - (long) i * num2;
            if (num <= 0) {
                return -1;
            } else if (Long.bitCount(num) <= i && num >= i) {
                return i;
            }
        }
        return -1;
    }

}
