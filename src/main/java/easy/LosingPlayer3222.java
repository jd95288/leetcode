package easy;

/**
 * 求出硬币游戏的赢家
 * <p>
 * 给你两个 正 整数 x 和 y ，分别表示价值为 75 和 10 的硬币的数目。
 * Alice 和 Bob 正在玩一个游戏。每一轮中，Alice 先进行操作，Bob 后操作。
 * 每次操作中，玩家需要拿出价值 总和 为 115 的硬币。如果一名玩家无法执行此操作，那么这名玩家 输掉 游戏。
 * 两名玩家都采取 最优 策略，请你返回游戏的赢家。
 *
 * @author jd95288
 * @date 2024-11-05 9:14
 */
public class LosingPlayer3222 {

    public String losingPlayer(int x, int y) {
        return Math.min(x, y / 4) % 2 == 0 ? "Bob" : "Alice";
    }

}
