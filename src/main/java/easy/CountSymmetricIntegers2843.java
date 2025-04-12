package easy;


/**
 * 统计对称整数的数目
 *
 * 给你两个正整数 low 和 high 。
 * 对于一个由 2 * n 位数字组成的整数 x ，如果其前 n 位数字之和与后 n 位数字之和相等，则认为这个数字是一个对称整数。
 * 返回在 [low, high] 范围内的 对称整数的数目 。
 *
 * @author jd95288
 * @date 2025-04-11 0:23
 */
public class CountSymmetricIntegers2843 {

    public int countSymmetricIntegers(int low, int high) {
        int res = 0;
        for (int i = low; i <= high; i++) {
            String num = String.valueOf(i);
            int r = num.length();
            if (r % 2 == 1) {
                continue;
            }
            r--;
            int l = 0;
            int diff = 0;
            while (l < r) {
                diff += num.charAt(l++) - num.charAt(r--);
            }
            res += diff != 0 ? 0 : 1;
        }
        return res;
    }
}
