package easy;

import java.util.Arrays;

/**
 * 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * @author jd95288
 * @date 2024-06-27 0:40
 */
public class PlusOne66 {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int n = digits.length;
        digits[n - 1]++;
        for (int i = n - 1; i >= 0; i--) {
            int add = digits[i] + carry;
            if (add > 9) {
                carry = 1;
                digits[i] = add % 10;
            } else {
                carry = 0;
                digits[i] = add;
                break;
            }
        }
        if (carry == 1) {
            int[] res = new int[n + 1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, n);
            return res;
        } else {
            return digits;
        }
    }

}
