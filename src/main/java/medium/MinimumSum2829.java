package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * k-avoiding 数组的最小总和
 * <p>
 * 给你两个整数 n 和 k 。
 * 对于一个由 不同 正整数组成的数组，如果其中不存在任何求和等于 k 的不同元素对，则称其为 k-avoiding 数组。
 * 返回长度为 n 的 k-avoiding 数组的可能的最小总和。
 *
 * @author jd95288
 * @date 2025-03-26 0:13
 */
public class MinimumSum2829 {

    public int minimumSum(int n, int k) {
        int res = 0;
        int length = 0;
        int num = 1;
        Set<Integer> avoiding = new HashSet<>();
        while (length < n) {
            if (avoiding.contains(num)) {
                num++;
                continue;
            }
            if (num < k) {
                avoiding.add(k - num);
            }
            length++;
            res += num;
            num++;
        }
        return res;
    }

}
