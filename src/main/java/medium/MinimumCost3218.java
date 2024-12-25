package medium;

import java.util.Arrays;

/**
 * 切蛋糕的最小总开销I
 * <p>
 * 有一个 m x n 大小的矩形蛋糕，需要切成 1 x 1 的小块。
 * 给你整数 m ，n 和两个数组：
 * - horizontalCut 的大小为 m - 1 ，其中 horizontalCut[i] 表示沿着水平线 i 切蛋糕的开销。
 * - verticalCut 的大小为 n - 1 ，其中 verticalCut[j] 表示沿着垂直线 j 切蛋糕的开销。
 * 一次操作中，你可以选择任意不是 1 x 1 大小的矩形蛋糕并执行以下操作之一：
 * 1. 沿着水平线 i 切开蛋糕，开销为 horizontalCut[i] 。
 * 2. 沿着垂直线 j 切开蛋糕，开销为 verticalCut[j] 。
 * 每次操作后，这块蛋糕都被切成两个独立的小蛋糕。
 * 每次操作的开销都为最开始对应切割线的开销，并且不会改变。
 * <p>
 * 请你返回将蛋糕全部切成 1 x 1 的蛋糕块的 最小 总开销。
 *
 * @author jd95288
 * @date 2024-12-25 10:41
 */
public class MinimumCost3218 {

    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        int horizontalCutPart = 1;
        int verticalCutPart = 1;
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        int h = horizontalCut.length - 1;
        int v = verticalCut.length - 1;
        int res = 0;
        while (h >= 0 || v >= 0) {
            if (h < 0){
                res += horizontalCutPart * verticalCut[v];
                v--;
                continue;
            }
            if (v < 0){
                res += verticalCutPart * horizontalCut[h];
                h--;
                continue;
            }
            if (horizontalCut[h] > verticalCut[v]) {
                res += verticalCutPart * horizontalCut[h];
                horizontalCutPart++;
                h--;
            } else if (horizontalCut[h] <= verticalCut[v]) {
                res += horizontalCutPart * verticalCut[v];
                verticalCutPart++;
                v--;
            }
        }

        return res;
    }

}
