package hard;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 你能从盒子里获得的最大糖果数
 * <p>
 * 给你 n 个盒子，每个盒子的格式为 [status, candies, keys, containedBoxes] ，其中：
 * 状态字 status[i]：整数，如果 box[i] 是开的，那么是 1 ，否则是 0 。
 * 糖果数 candies[i]: 整数，表示 box[i] 中糖果的数目。
 * 钥匙 keys[i]：数组，表示你打开 box[i] 后，可以得到一些盒子的钥匙，每个元素分别为该钥匙对应盒子的下标。
 * 内含的盒子 containedBoxes[i]：整数，表示放在 box[i] 里的盒子所对应的下标。
 * 给你一个 initialBoxes 数组，表示你现在得到的盒子，你可以获得里面的糖果，也可以用盒子里的钥匙打开新的盒子，还可以继续探索从这个盒子里找到的其他盒子。
 * 请你按照上述规则，返回可以获得糖果的 最大数目 。
 *
 * @author jd95288
 * @date 2025-06-03 20:30
 */
public class MaxCandies1298 {

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        int[][] boxes = new int[n][2];
        for (int i = 0; i < n; i++) {
            boxes[i] = new int[]{i, status[i]};
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int initialBox : initialBoxes) {
            q.offer(boxes[initialBox]);
        }
        int res = 0;
        Set<Integer> visited = new HashSet<>();
        while (!q.isEmpty() && q.peek()[1] == 1) {
            while (!q.isEmpty() && q.peek()[1] == 1) {
                int i = q.poll()[0];
                visited.add(i);
                res += candies[i];
                for (int j : keys[i]) {
                    boxes[j][1] = 1;
                }
                for (int j : containedBoxes[i]) {
                    if (visited.contains(j)) {
                        continue;
                    }
                    q.offer(boxes[j]);
                }
            }
        }
        return res;
    }
}
