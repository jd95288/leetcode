package medium;


/**
 * 爱生气的书店老板
 * <p>
 * 有一个书店老板，他的书店开了 n 分钟。每分钟都有一些顾客进入这家商店。
 * 给定一个长度为 n 的整数数组 customers ，其中 customers[i] 是在第 i 分钟开始时进入商店的顾客数量，所有这些顾客在第 i 分钟结束后离开。
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。
 * 当书店老板生气时，那一分钟的顾客就会不满意，若老板不生气则顾客是满意的。
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 minutes 分钟不生气，但却只能使用一次。
 * <p>
 * 请你返回 这一天营业下来，最多有多少客户能够感到满意 。
 *
 * @author jd95288
 * @date 2024-04-23 8:40
 */
public class MaxSatisfied1052 {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += customers[i] * (1 - grumpy[i]);
        }
        int unsatisfiedInWindow = 0;
        for (int i = 0; i < minutes; i++) {
            unsatisfiedInWindow += customers[i] * grumpy[i];
        }
        int max = unsatisfiedInWindow;
        for (int i = minutes; i < n; i++) {
            unsatisfiedInWindow = unsatisfiedInWindow
                    - customers[i - minutes] * grumpy[i - minutes]
                    + customers[i] * grumpy[i];
            max = Math.max(max, unsatisfiedInWindow);
        }
        return total + max;
    }
}
