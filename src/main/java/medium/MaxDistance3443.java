package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * K 次修改后的最大曼哈顿距离
 * <p>
 * 给你一个由字符 'N'、'S'、'E' 和 'W' 组成的字符串 s，其中 s[i] 表示在无限网格中的移动操作：
 * 'N'：向北移动 1 个单位。
 * 'S'：向南移动 1 个单位。
 * 'E'：向东移动 1 个单位。
 * 'W'：向西移动 1 个单位。
 * 初始时，你位于原点 (0, 0)。你 最多 可以修改 k 个字符为任意四个方向之一。
 * 请找出在 按顺序 执行所有移动操作过程中的 任意时刻 ，所能达到的离原点的 最大曼哈顿距离 。
 * 曼哈顿距离 定义为两个坐标点 (xi, yi) 和 (xj, yj) 的横向距离绝对值与纵向距离绝对值之和，即 |xi - xj| + |yi - yj|。
 *
 * @author jd95288
 * @date 2025-06-20 21:47
 */
public class MaxDistance3443 {

    private static final Map<Character, int[]> MAP = new HashMap<>();

    static {
        MAP.put('N', new int[]{0, 1});
        MAP.put('S', new int[]{0, -1});
        MAP.put('E', new int[]{1, 0});
        MAP.put('W', new int[]{-1, 0});
    }

    public int maxDistance(String s, int k) {
        int res = 0;
        int d = 0;
        int prev = 0;
        int backCnt = 0;
        int[] curPos = new int[]{0, 0};
        char[] move = s.toCharArray();
        for (char dir : move) {
            prev = d;
            int[] delta = MAP.get(dir);
            int dx = delta[0];
            int dy = delta[1];
            curPos[0] += dx;
            curPos[1] += dy;
            d = Math.abs(curPos[0]) + Math.abs(curPos[1]);
            if (prev > d) {
                backCnt++;
            }
            res = Math.max(res, d + Math.min(backCnt, k) * 2);
        }
        return res;
    }
}
