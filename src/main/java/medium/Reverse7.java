package medium;

/**
 * 整数反转
 * <p>
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * @author jd95288
 * @date 2025-06-11 23:08
 */
public class Reverse7 {

    public int reverse(int x) {
        boolean negative = x < 0;
        if (negative) {
            x = -x;
        }
        int l = String.valueOf(x).length();
        int[] arr = new int[l];
        int i = 0;
        while (x > 0) {
            arr[i++] = x % 10;
            x /= 10;
        }
        StringBuilder sb = new StringBuilder();
        if (negative) {
            sb.append("-");
        }
        for (int num : arr) {
            sb.append(num);
        }
        int res = 0;
        try {
            res = Integer.parseInt(sb.toString());
        } catch (NumberFormatException ignored) {

        }
        return res;
    }

}
