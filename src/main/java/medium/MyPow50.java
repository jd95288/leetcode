package medium;

/**
 * Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 *
 * @author jd95288
 * @date 2024-08-16 10:19
 */
public class MyPow50 {

    public double myPow(double x, int n) {
        long cnt = n >= 0 ? n : -((long) n);
        double res = 1.0;
        while (cnt > 0) {
            if ((cnt & 1) == 1) {
                res = res * x;
            }
            x = x * x;
            cnt = cnt >> 1;
        }
        return n == 0 ? 1 : n > 0 ? res : 1 / res;
    }

}
