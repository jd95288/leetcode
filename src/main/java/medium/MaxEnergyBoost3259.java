package medium;

/**
 * 超级饮料的最大强化能量
 * <p>
 * 来自未来的体育科学家给你两个整数数组 energyDrinkA 和 energyDrinkB，数组长度都等于 n。
 * 这两个数组分别代表 A、B 两种不同能量饮料每小时所能提供的强化能量。
 * 你需要每小时饮用一种能量饮料来 最大化 你的总强化能量。
 * 然而，如果从一种能量饮料切换到另一种，你需要等待一小时来梳理身体的能量体系（在那个小时里你将不会获得任何强化能量）。
 * 返回在接下来的 n 小时内你能获得的 最大 总强化能量。
 * 注意 你可以选择从饮用任意一种能量饮料开始。
 *
 * @author jd95288
 * @date 2024-11-01 0:37
 */
public class MaxEnergyBoost3259 {

    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        long prevA = energyDrinkA[0];
        long prevB = energyDrinkB[0];
        for (int i = 1; i < n; i++) {
            long curA = Math.max(prevB,  prevA + energyDrinkA[i]);
            long curB = Math.max(prevA,  prevB + energyDrinkB[i]);
            prevA = curA;
            prevB = curB;
        }
        return Math.max(prevA, prevB);
    }

}
