package easy;

/**
 * 构造相同颜色的正方形
 * <p>
 * 给你一个二维 3 x 3 的矩阵 grid ，每个格子都是一个字符，要么是 'B' ，要么是 'W' 。
 * 字符 'W' 表示白色，字符 'B' 表示黑色。
 * 你的任务是改变 至多一个 格子的颜色，使得矩阵中存在一个 2 x 2 颜色完全相同的正方形。
 * 如果可以得到一个相同颜色的 2 x 2 正方形，那么返回 true ，否则返回 false 。
 *
 * @author jd95288
 * @date 2024-08-31 21:28
 */
public class CanMakeSquare3127 {
    static private final int[][][] directions = new int[][][]{
            {{-1, 0}, {-1, -1}, {0, -1}},
            {{1, 0}, {1, -1}, {0, -1}},
            {{-1, 0}, {-1, 1}, {0, 1}},
            {{1, 0}, {1, 1}, {0, 1}}
    };

    public boolean canMakeSquare(char[][] grid) {
        char mid = grid[1][1];
        for (int[][] direction : directions) {
            int cnt = 0;
            for (int[] cor : direction) {
                if (mid != grid[1 + cor[0]][1 + cor[1]]) {
                    cnt++;
                }
            }
            if (cnt != 2) {
                return true;
            }
        }
        return false;
    }

}
