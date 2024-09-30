package medium;

import java.util.PriorityQueue;

/**
 * 座位预约管理系统
 *
 * 请你设计一个管理 n 个座位预约的系统，座位编号从 1 到 n 。
 * 请你实现 SeatManager 类：
 * SeatManager(int n) 初始化一个 SeatManager 对象，它管理从 1 到 n 编号的 n 个座位。所有座位初始都是可预约的。
 * int reserve() 返回可以预约座位的 最小编号 ，此座位变为不可预约。
 * void unreserve(int seatNumber) 将给定编号 seatNumber 对应的座位变成可以预约。
 *
 * @author jd95288
 * @date 2024-09-30 21:46
 */
public class SeatManager1845 {

    class SeatManager {

        private PriorityQueue<Integer> q;

        public SeatManager(int n) {
            q = new PriorityQueue<>();
            for (int i = 1; i <= n; i++) {
                q.offer(i);
            }
        }

        public int reserve() {
            return q.poll();
        }

        public void unreserve(int seatNumber) {
            q.offer(seatNumber);
        }
    }

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
}
