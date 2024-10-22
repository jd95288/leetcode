package medium;

/**
 * 鸡蛋掉落-两枚鸡蛋
 * <p>
 * 给你 2 枚相同 的鸡蛋，和一栋从第 1 层到第 n 层共有 n 层楼的建筑。
 * 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都 会碎 ，
 * 从 f 楼层或比它低 的楼层落下的鸡蛋都 不会碎 。
 * 每次操作，你可以取一枚 没有碎 的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。
 * 如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
 * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
 *
 * @author jd95288
 * @date 2024-10-13 19:30
 */
public class TwoEggDrop1884 {

    public int twoEggDrop_v1(int n) {
        return (int) Math.ceil((Math.sqrt(1 + 8 * n) - 1) / 2);
    }

}