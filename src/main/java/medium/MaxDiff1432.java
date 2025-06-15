package medium;

/**
 * 改变一个整数能得到的最大差值
 *
 * 给你一个整数 num 。你可以对它进行以下步骤共计 两次：
 * 选择一个数字 x (0 <= x <= 9).
 * 选择另一个数字 y (0 <= y <= 9) 。数字 y 可以等于 x 。
 * 将 num 中所有出现 x 的数位都用 y 替换。
 * 令两次对 num 的操作得到的结果分别为 a 和 b 。
 * 请你返回 a 和 b 的 最大差值 。
 * 注意，新的整数（a 或 b）必须不能 含有前导 0，并且 非 0。
 *
 * @author jd95288
 * @date 2025-06-15 18:15
 */
public class MaxDiff1432 {

    public int maxDiff(int num) {
        int a = num, b = num;
        String s = String.valueOf(num);
        int n = s.length();
        int m = (int) Math.pow(10, n - 1);
        int ar = '-', br = '-';
        boolean first = false;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (ar == '-' && c != '9') {
                ar = c;
            }
            if (br == '-' && c > '1') {
                br = c;
                first = i == 0;
            }
            if (ar == c) {
                a += (9 - (c - '0')) * m;
            }
            if (br == c) {
                b -= ((c - '0') - (first ? 1 : 0)) * m;
            }
            m /= 10;
        }
        return a - b;
    }
}
