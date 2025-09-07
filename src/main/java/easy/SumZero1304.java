package easy;

/**
 * 和为零的 N 个不同整数
 * <p>
 * 给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
 *
 * @author jd95288
 * @date 2025-09-07 19:10
 */
public class SumZero1304 {

    public int[] sumZero(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n - 1; i += 2) {
            res[i] = i + 1;
            res[i + 1] = -i - 1;
        }
        return res;
    }
}
