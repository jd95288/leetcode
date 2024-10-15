package easy;

/**
 * 三角形的最大高度
 * <p>
 * 给你两个整数 red 和 blue，分别表示红色球和蓝色球的数量。
 * 你需要使用这些球来组成一个三角形，满足第 1 行有 1 个球，第 2 行有 2 个球，第 3 行有 3 个球，依此类推。
 * 每一行的球必须是 相同 颜色，且相邻行的颜色必须 不同。
 * 返回可以实现的三角形的 最大 高度。
 *
 * @author jd95288
 * @date 2024-10-15 9:25
 */
public class MaxHeightOfTriangle3200 {

    public int maxHeightOfTriangle(int red, int blue) {
        int redOddRowCnt = (int) Math.sqrt(red);
        int redEvenRowCnt = (int) ((Math.sqrt(1 + 4 * red) - 1) / 2);
        int blueOddRowCnt = (int) Math.sqrt(blue);
        int blueEvenRowCnt = (int) ((Math.sqrt(1 + 4 * blue) - 1) / 2);
        int r, b;
        if (redOddRowCnt - blueEvenRowCnt >= 1) {
            r = 2 * blueEvenRowCnt + 1;
        } else {
            r = 2 * redOddRowCnt;
        }
        if (blueOddRowCnt - redEvenRowCnt >= 1) {
            b = 2 * redEvenRowCnt + 1;
        } else {
            b = 2 * blueOddRowCnt;
        }
        return Math.max(r, b);
    }

}
