package medium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 最多可以参加的会议数目
 * <p>
 * 给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，表示会议 i 开始于 startDayi ，结束于 endDayi 。
 * 你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。在任意一天 d 中只能参加一场会议。
 * 请你返回你可以参加的 最大 会议数目。
 *
 * @author jd95288
 * @date 2025-07-07 9:07
 */
public class MaxEvents1353 {

    public int maxEvents(int[][] events) {
        int max = 0;
        for (int[] event : events) {
            max = Math.max(max, event[1]);
        }
        List<Integer>[] groups = new List[max + 1];
        Arrays.setAll(groups, x -> new ArrayList<>());
        for (int[] event : events) {
            groups[event[0]].add(event[1]);
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int res = 0;
        for (int i = 1; i <= max; i++) {
            while (!q.isEmpty() && q.peek() < i) {
                q.poll();
            }
            q.addAll(groups[i]);
            if (!q.isEmpty()) {
                res++;
                q.poll();
            }
        }
        return res;
    }

}
