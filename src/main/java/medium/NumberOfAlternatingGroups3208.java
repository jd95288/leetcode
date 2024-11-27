package medium;

/**
 * 交替组II
 * <p>
 * 有一个环形二进制数组（认为首尾相邻），如果连续的 k 个元素除了第一个与最后一个元素外，
 * 内部元素与它左边和右边的元素不同，则称这 k 个元素为一个交替组，求交替组的个数。
 *
 * @author jd95288
 * @date 2024-11-26 9:31
 */
public class NumberOfAlternatingGroups3208 {

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int res = 0;
        int n = colors.length;
        int prev = colors[n - k + 1];
        int size = 1;
        for (int i = n - k + 2; i < n; i++) {
            if (colors[i] == prev) {
                size = 1;
            } else {
                size++;
            }
            prev = colors[i];
        }
        for (int i = 0; i < n; i++) {
            if (colors[i] == prev) {
                size = 1;
            } else {
                size++;
            }
            prev = colors[i];
            if (size >= k) {
                res++;
            }
        }
        return res;
    }

}
