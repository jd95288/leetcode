package hard;

/**
 * 字典序的第K小数字
 * <p>
 * 给定整数 n 和 k，返回  [1, n] 中字典序第 k 小的数字。
 * <p>
 * 1 <= k <= n <= 10^9
 *
 * @author jd95288
 * @date 2025-06-09 8:44
 */
public class FindKthNumber440 {

    public int findKthNumber(int n, int k) {
        int i = 1;
        k--;
        while (k > 0) {
            int cnt = subTreeNodesCnt(i, n);
            if (cnt <= k) {
                k -= cnt;
                i++;
            } else {
                k--;
                i *= 10;
            }
        }

        return i;
    }

    public int subTreeNodesCnt(int root, int n) {
        int cnt = 0;
        long l = root;
        long r = root + 1;
        while (l <= n) {
            cnt += Math.min(r, n + 1) - l;
            l *= 10;
            r *= 10;
        }
        return cnt;
    }
}
