package medium;

import java.util.Arrays;

/**
 * 将整数按权重排序
 * <p>
 * 定义整数 x 的权重为 将其变为 1 的操作次数，根据整数的奇偶性，可以执行不同的操作：
 * x 为偶数，x -> x / 2
 * x 为奇数，x -> 3 * x + 1
 * 返回区间 [lo, hi] 之间的整数按权重排序后的第 k 个数。
 *
 * @author jd95288
 * @date 2024-12-22 16:20
 */
public class GetKth1387 {

    public int getKth(int lo, int hi, int k) {
        int n = hi - lo + 1;
        int[][] w = new int[n][2];
        int c = 0;
        for (int i = lo; i <= hi; i++) {
            w[c++] = new int[]{getWeight(i), i};
        }
        Arrays.sort(w, (a, b) -> {
            int compare = a[0] - b[0];
            if (compare != 0) {
                return compare;
            }
            return a[1] - b[1];
        });
        return w[k - 1][1];
    }

    static public int getWeight(int x) {
        int cnt = 0;
        while (x > 1) {
            if (x % 2 == 0) {
                x >>= 1;
            } else {
                x = 3 * x + 1;
            }
            cnt++;
        }
        return cnt;
    }

}
