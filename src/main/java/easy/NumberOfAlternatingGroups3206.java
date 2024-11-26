package easy;

/**
 * 交替组I
 * <p>
 * 有一个环形二进制数组（认为首尾相邻），判断存在多少个交替组，
 * 如果元素与它左右相邻的两个元素值不相等，称这三个元素为一个交替组。
 *
 * @author jd95288
 * @date 2024-11-26 8:56
 */
public class NumberOfAlternatingGroups3206 {

    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int res = 0;
        boolean b = colors[n - 1] != colors[0];
        if (colors[0] != colors[1] && b) {
            res++;
        }
        if (colors[n - 1] != colors[n - 2] && b) {
            res++;
        }
        for (int i = 1; i < n - 1; i++) {
            if (colors[i - 1] != colors[i] && colors[i + 1] != colors[i]) {
                res++;
            }
        }
        return res;
    }

}
