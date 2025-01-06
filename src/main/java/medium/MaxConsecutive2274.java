package medium;

import java.util.Arrays;

/**
 * 不含特殊楼层的最大连续楼层数
 * <p>
 * Alice 管理着一家公司，并租用大楼的部分楼层作为办公空间。Alice 决定将一些楼层作为 特殊楼层 ，仅用于放松。
 * 给你两个整数 bottom 和 top ，表示 Alice 租用了从 bottom 到 top（含 bottom 和 top 在内）的所有楼层。
 * 另给你一个整数数组 special ，其中 special[i] 表示  Alice 指定用于放松的特殊楼层。
 * 返回不含特殊楼层的 最大 连续楼层数。
 *
 * @author jd95288
 * @date 2025-01-06 8:42
 */
public class MaxConsecutive2274 {

    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        bottom--;
        top++;
        int res = 0;
        int n = special.length;
        int prev = bottom;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, special[i] - prev - 1);
            prev = special[i];
        }
        return Math.max(res, top - special[n - 1] - 1);
    }

}
