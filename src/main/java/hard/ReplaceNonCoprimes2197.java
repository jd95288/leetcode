package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 替换数组中的非互质数
 * <p>
 * 给你一个整数数组 nums 。请你对数组执行下述操作：
 * <p>
 * 从 nums 中找出 任意 两个 相邻 的 非互质 数。
 * 如果不存在这样的数，终止 这一过程。
 * 否则，删除这两个数，并 替换 为它们的 最小公倍数（Least Common Multiple，LCM）。
 * 只要还能找出两个相邻的非互质数就继续 重复 这一过程。
 * <p>
 * 返回修改后得到的 最终 数组。可以证明的是，以 任意 顺序替换相邻的非互质数都可以得到相同的结果。
 * <p>
 * 生成的测试用例可以保证最终数组中的值 小于或者等于 108 。
 * <p>
 * 两个数字 x 和 y 满足 非互质数 的条件是：GCD(x, y) > 1 ，其中 GCD(x, y) 是 x 和 y 的 最大公约数 。
 *
 * @author jd95288
 * @date 2025-09-16 8:45
 */
public class ReplaceNonCoprimes2197 {

    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int a : nums) {
            while (!list.isEmpty()) {
                int b = list.get(list.size() - 1);
                int g = gcd(a, b);
                if (g <= 1) {
                    break;
                }
                a = a / g * b;
                list.remove(list.size() - 1);
            }
            list.add(a);
        }
        return list;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
