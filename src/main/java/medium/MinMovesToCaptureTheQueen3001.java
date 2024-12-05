package medium;

/**
 * 捕获黑皇后需要的最少移动次数
 * <p>
 * 现有一个下标从 1 开始的 8 x 8 棋盘，上面有 3 枚棋子。
 * 给你 6 个整数 a 、b 、c 、d 、e 和 f ，其中：
 * (a, b) 表示白色车的位置。
 * (c, d) 表示白色象的位置。
 * (e, f) 表示黑皇后的位置。
 * 假定你只能移动白色棋子，返回捕获黑皇后所需的最少移动次数。
 * <p>
 * 请注意：
 * 车可以向垂直或水平方向移动任意数量的格子，但不能跳过其他棋子。
 * 象可以沿对角线方向移动任意数量的格子，但不能跳过其他棋子。
 * 如果车或象能移向皇后所在的格子，则认为它们可以捕获皇后。
 * 皇后不能移动。
 *
 * @author jd95288
 * @date 2024-12-05 10:06
 */
public class MinMovesToCaptureTheQueen3001 {

    public int minMovesToCaptureTheQueen_v1(int a, int b, int c, int d, int e, int f) {
        if (a == e && (a != c || d < Math.min(b, f) || d > Math.max(b, f))) {
            return 1;
        }
        if (b == f && (b != d || c < Math.min(a, e) || c > Math.max(a, e))) {
            return 1;
        }
        if (c + d == e + f && (a + b != c + d || a < Math.min(c, e) || a > Math.max(c, e))) {
            return 1;
        }
        if (c - d == e - f && (a - b != c - d || a < Math.min(c, e) || a > Math.max(c, e))) {
            return 1;
        }
        return 2;
    }

}
