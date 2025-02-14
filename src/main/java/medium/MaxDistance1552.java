package medium;

import java.util.Arrays;

/**
 * 两球之间的磁力
 * <p>
 * 在代号为 C-137 的地球上，Rick 发现如果他将两个球放在他新发明的篮子里，它们之间会形成特殊形式的磁力。
 * Rick 有 n 个空的篮子，第 i 个篮子的位置在 position[i] ，
 * Morty 想把 m 个球放到这些篮子里，使得任意两球间 最小磁力 最大。
 * 已知两个球如果分别位于 x 和 y ，那么它们之间的磁力为 |x - y| 。
 * 给你一个整数数组 position 和一个整数 m ，请你返回最大化的最小磁力。
 *
 * @author jd95288
 * @date 2025-02-14 9:35
 */
public class MaxDistance1552 {

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        // 总共 m - 1 个相邻磁力，最小磁力不可能小于 max / (m - 1)
        int left = 0, right = position[n - 1] / (m - 1);
        int mid = left + (right - left) / 2;
        while (left <= right) {
            // 第一个位置必定放一个球，传参 m - 1
            if (check(mid, position, m - 1)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = left + (right - left) / 2;
        }
        return right;
    }

    public boolean check(int mid, int[] position, int m) {
        int start = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] >= start + mid) {
                if (--m == 0) {
                    return true;
                }
                start = position[i];
            }
        }
        return false;
    }

}
