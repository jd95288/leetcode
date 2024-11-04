package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 平方数之和
 * <p>
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c 。
 *
 * @author jd95288
 * @date 2024-11-04 0:17
 */
public class JudgeSquareSum633 {

    public static Set<Integer> set = new HashSet<>(100000);

    static {
        long i = 0;
        long square = 0;
        while (true) {
            square = i * i;
            if (square > Integer.MAX_VALUE) {
                break;
            }
            set.add((int) square);
            i++;
        }
    }

    public boolean judgeSquareSum(int c) {
        long i = 0;
        long square = 0;
        while (true) {
            square = i * i;
            if (square > c) {
                break;
            } else if (set.contains((int) (c - square))) {
                return true;
            }
            i++;
        }
        return false;
    }

}
