package easy;

import java.util.PriorityQueue;

/**
 * 心算挑战
 * <p>
 * 「力扣挑战赛」心算项目的挑战比赛中，要求选手从 N 张卡牌中选出 cnt 张卡牌，
 * 若这 cnt 张卡牌数字总和为偶数，则选手成绩「有效」且得分为 cnt 张卡牌数字总和。
 * 给定数组 cards 和 cnt，其中 cards[i] 表示第 i 张卡牌上的数字。
 * 请帮参赛选手计算最大的有效得分。若不存在获取有效得分的卡牌方案，则返回 0。
 *
 * @author jd95288
 * @date 2024-08-01 20:24
 */
public class MaxmiumScoreLCP40 {

    /**
     * 执行通过
     */
    public int maxmiumScore(int[] cards, int cnt) {
        int res = 0;
        PriorityQueue<Integer> odd = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> even = new PriorityQueue<>((a, b) -> b - a);
        for (int card : cards) {
            if (card % 2 == 0) {
                even.offer(card);
            } else {
                odd.offer(card);
            }
        }
        if (cnt == 1 && even.size() > 0) {
            return even.poll();
        } else if (cnt == 1) {
            return 0;
        }
        int oddCnt = 0;
        int lastOdd = 0;
        int lastEven = 0;
        while (cnt > 1) {
            if (!odd.isEmpty() && !even.isEmpty() && odd.peek() > even.peek()) {
                lastOdd = odd.poll();
                res += lastOdd;
                oddCnt++;
            } else if (!odd.isEmpty() && !even.isEmpty()) {
                lastEven = even.poll();
                res += lastEven;
            } else if (!odd.isEmpty()) {
                lastOdd = odd.poll();
                res += lastOdd;
                oddCnt++;
            } else if (!even.isEmpty()) {
                lastEven = even.poll();
                res += lastEven;
            }
            cnt--;
        }
        if (oddCnt % 2 == 1 && !odd.isEmpty()) {
            if (even.size() >= 2) {
                int tmp = even.poll();
                tmp += even.poll();
                if (tmp > lastOdd + odd.peek()) {
                    res += tmp - lastOdd;
                } else {
                    res += odd.poll();
                }
            } else {
                res += odd.poll();
            }
        } else if (oddCnt % 2 == 1 && even.size() >= 2) {
            res -= lastOdd;
            res += even.poll();
            res += even.poll();
        } else if (oddCnt % 2 == 0) {
            if (odd.size() >= 2 && lastEven != 0) {
                int tmp = odd.poll();
                tmp += odd.poll();
                if (even.size() == 0 || tmp > lastEven + even.peek()) {
                    res += tmp - lastEven;
                } else {
                    res += even.poll();
                }
            } else {
                if (even.size() == 0) {
                    return 0;
                } else {
                    res += even.poll();
                }
            }
        } else {
            res = 0;
        }
        return res;
    }

}
