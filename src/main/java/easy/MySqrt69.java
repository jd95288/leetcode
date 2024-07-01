package easy;

/**
 * x 的平方根
 * <p>
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 * @author jd95288
 * @date 2024-06-30 23:13
 */
public class MySqrt69 {


    public int mySqrt(int x) {
        long res = 0;
        while (res * res <= x) {
            res++;
        }
        return (int) res - 1;
    }

}
