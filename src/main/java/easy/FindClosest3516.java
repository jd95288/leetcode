package easy;

/**
 * 找到最近的人
 * <p>
 * 给你三个整数 x、y 和 z，表示数轴上三个人的位置：
 * <p>
 * x 是第 1 个人的位置。
 * y 是第 2 个人的位置。
 * z 是第 3 个人的位置，第 3 个人 不会移动 。
 * 第 1 个人和第 2 个人以 相同 的速度向第 3 个人移动。
 * <p>
 * 判断谁会 先 到达第 3 个人的位置：
 * 如果第 1 个人先到达，返回 1 。
 * 如果第 2 个人先到达，返回 2 。
 * 如果两个人同时到达，返回 0 。
 * 根据上述规则返回结果。
 *
 * @author jd95288
 * @date 2025-09-04 8:44
 */
public class FindClosest3516 {

    public int findClosest(int x, int y, int z) {
        int dx = Math.abs(x - z);
        int dy = Math.abs(y - z);
        return dx == dy ? 0 : dx < dy ? 1 : 2;
    }
}
