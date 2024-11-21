package easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 矩阵中的蛇
 * <p>
 * 有一个 `n x n` 矩阵 `grid`，
 * 初始时位置 `(0, 0)` 有条蛇，有一系列命令可以操作蛇移到，操作保证在矩阵内移动，
 * 问蛇最后停留的位置，格子的标识为 `grid[i][j] = (i * n) + j`。
 *
 * @author jd95288
 * @date 2024-11-21 0:39
 */
public class FinalPositionOfSnake3248 {

    /**
     * 最快题解
     */
    class Solution {
        public int finalPositionOfSnake(int n, List<String> commands) {
            int ans = 0;
            for (String c : commands) {
                if (c.charAt(0) == 'U') {
                    ans -= n;
                } else if (c.charAt(0) == 'D') {
                    ans += n;
                } else if (c.charAt(0) == 'L') {
                    --ans;
                } else {
                    ++ans;
                }
            }
            return ans;
        }
    }


    public static Map<String, int[]> map = new HashMap<>(4);

    static {
        map.put("UP", new int[]{-1, 0});
        map.put("RIGHT", new int[]{0, 1});
        map.put("DOWN", new int[]{1, 0});
        map.put("LEFT", new int[]{0, -1});
    }

    public int finalPositionOfSnake(int n, List<String> commands) {
        int[] move = new int[2];
        for (String command : commands) {
            move[0] += map.get(command)[0];
            move[1] += map.get(command)[1];
        }
        return move[0] * n + move[1];
    }

}
