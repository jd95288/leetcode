package medium;


/**
 * 行相等的最少多米诺旋转
 * <p>
 * 在一排多米诺骨牌中，tops[i] 和 bottoms[i] 分别代表第 i 个多米诺骨牌的上半部分和下半部分。
 * （一个多米诺是两个从 1 到 6 的数字同列平铺形成的 —— 该平铺的每一半上都有一个数字。）
 * 我们可以旋转第 i 张多米诺，使得 tops[i] 和 bottoms[i] 的值交换。
 * 返回能使 tops 中所有值或者 bottoms 中所有值都相同的最小旋转次数。
 * 如果无法做到，返回 -1.
 *
 * @author jd95288
 * @date 2025-05-03 20:46
 */
public class MinDominoRotations1007 {

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int res = Math.min(ops(tops, bottoms, tops[0]), ops(tops, bottoms, bottoms[0]));
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int ops(int[] tops, int[] bottoms, int target) {
        int topCnt = 0;
        int bottomCnt = 0;
        for (int i = 0; i < tops.length; i++) {
            if (target != tops[i] && target != bottoms[i]) {
                return Integer.MAX_VALUE;
            }
            if (target != tops[i]) {
                topCnt++;
            } else if (target != bottoms[i]) {
                bottomCnt++;
            }
        }
        return Math.min(topCnt, bottomCnt);
    }

}
