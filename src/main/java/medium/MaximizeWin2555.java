package medium;

/**
 * 两个线段获得的最多奖品
 * <p>
 * 在 X轴 上有一些奖品。给你一个整数数组 prizePositions ，它按照 非递减 顺序排列，
 * 其中 prizePositions[i] 是第 i 件奖品的位置。数轴上一个位置可能会有多件奖品。再给你一个整数 k 。
 * 你可以选择两个端点为整数的线段。每个线段的长度都必须是 k 。
 * 你可以获得位置在任一线段上的所有奖品（包括线段的两个端点）。注意，两个线段可能会有相交。
 * 比方说 k = 2 ，你可以选择线段 [1, 3] 和 [2, 4] ，
 * 你可以获得满足 1 <= prizePositions[i] <= 3 或者 2 <= prizePositions[i] <= 4 的所有奖品 i 。
 * 请你返回在选择两个最优线段的前提下，可以获得的 最多 奖品数目。
 *
 * @author jd95288
 * @date 2024-09-11 8:57
 */
public class MaximizeWin2555 {

    public int maximizeWin_v1(int[] prizePositions, int k) {
        int n = prizePositions.length;
        if (k * 2 + 1 >= prizePositions[n - 1] - prizePositions[0]) {
            return n;
        }
        int res = 1;
        int[] max = new int[n + 1];
        int l = n - 1;
        for (int r = n - 1; r >= 0; r--) {
            while (l >= 0 && prizePositions[r] - prizePositions[l] <= k) {
                max[l] = Math.max(r - l + 1, max[l + 1]);
                res = Math.max(res, r - l + 1 + max[r + 1]);
                l--;
            }
        }
        return res;
    }

}
