package easy;

/**
 * 判断是否可以赢得数字游戏
 * <p>
 * 给你一个 正整数 数组 nums。
 * Alice 和 Bob 正在玩游戏。在游戏中，Alice 可以从 nums 中选择所有个位数 或 所有两位数，剩余的数字归 Bob 所有。
 * 如果 Alice 所选数字之和 严格大于 Bob 的数字之和，则 Alice 获胜。
 * 如果 Alice 能赢得这场游戏，返回 true；否则，返回 false。
 * <p>
 * 只要个位数之和与两位数之和不等就可以获胜。
 *
 * @author jd95288
 * @date 2024-11-30 1:23
 */
public class CanAliceWin3232 {

    public boolean canAliceWin(int[] nums) {
        int one = 0;
        int two = 0;
        for (int num : nums) {
            if (num < 10) {
                one += num;
            } else {
                two += num;
            }
        }
        return one != two;
    }
}
