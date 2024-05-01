package medium;

import java.util.PriorityQueue;

/**
 * 雇佣 K 位工人的总代价
 * <p>
 * 给你一个下标从 0 开始的整数数组 costs ，其中 costs[i] 是雇佣第 i 位工人的代价。
 * 同时给你两个整数 k 和 candidates 。我们想根据以下规则恰好雇佣 k 位工人：
 * 总共进行 k 轮雇佣，且每一轮恰好雇佣一位工人。
 * 在每一轮雇佣中，从最前面 candidates 和最后面 candidates 人中选出代价最小的一位工人，
 * 如果有多位代价相同且最小的工人，选择下标更小的一位工人。
 * 比方说，costs = [3,2,7,7,1,2] 且 candidates = 2 ，
 * 第一轮雇佣中，我们选择第 4 位工人，因为他的代价最小 [3,2,7,7,1,2] 。
 * 第二轮雇佣，我们选择第 1 位工人，因为他们的代价与第 4 位工人一样都是最小代价，
 * 而且下标更小，[3,2,7,7,2] 。注意每一轮雇佣后，剩余工人的下标可能会发生变化。
 * 如果剩余员工数目不足 candidates 人，那么下一轮雇佣他们中代价最小的一人，
 * 如果有多位代价相同且最小的工人，选择下标更小的一位工人。
 * 一位工人只能被选择一次。
 * 返回雇佣恰好 k 位工人的总代价。
 *
 * @author jd95288
 * @date 2024-05-01 17:03
 */
public class TotalCost2462 {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer[]> q = new PriorityQueue<>((x, y) -> {
            int compare = x[0] - y[0];
            return compare == 0 ? x[1] - y[1] : compare;
        });
        int n = costs.length;
        int leftPos;
        int rightPos = n - 1;
        for (leftPos = 0; leftPos < candidates; leftPos++) {
            if (leftPos < rightPos) {
                q.offer(new Integer[]{costs[leftPos], leftPos});
                q.offer(new Integer[]{costs[rightPos], rightPos});
                rightPos--;
            } else if (leftPos == rightPos) {
                q.offer(new Integer[]{costs[leftPos], leftPos});
            } else {
                break;
            }
        }
        // 不使用long会溢出
        long res = 0;
        for (int i = 0; i < k && !q.isEmpty(); i++) {
            Integer[] c = q.poll();
            res += c[0];
            // 经过上面的处理，right指向的位置可能还未加入队列（除非上面leftPos == rightPos）
            if (leftPos > rightPos) {
                continue;
            }
            if (c[1] < leftPos) {
                q.offer(new Integer[]{costs[leftPos], leftPos});
                leftPos++;
            } else if (c[1] >= rightPos) {
                q.offer(new Integer[]{costs[rightPos], rightPos});
                rightPos--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TotalCost2462 main = new TotalCost2462();
//        System.out.println(main.totalCost(new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8}, 3, 4));
        System.out.println(main.totalCost(new int[]{31,25,72,79,74,65,84,91,18,59,27,9,81,33,17,58}, 11, 2));
    }
}
