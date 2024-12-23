package medium;

import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * 考场就座
 * <p>
 * 在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。
 * 当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。
 * 如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)
 * 返回 ExamRoom(int N) 类，它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），
 * 代表学生坐的位置；函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。
 * 每次调用 ExamRoom.leave(p) 时都保证有学生坐在座位 p 上。
 *
 * @author jd95288
 * @date 2024-12-23 14:28
 */
public class ExamRoom855 {

    static class ExamRoom {

        private TreeSet<Integer> occupied;
        private PriorityQueue<int[]> q;
        private int n;

        public ExamRoom(int n) {
            this.n = n;
            occupied = new TreeSet<>();
            q = new PriorityQueue<>((a, b) -> {
                int compare = b[0] / 2 - a[0] / 2;
                if (compare != 0) {
                    return compare;
                }
                return a[1] - b[1];
            });
        }

        public int seat() {
            if (occupied.size() == 0) {
                occupied.add(0);
                return 0;
            } else if (occupied.size() == 1) {
                Integer no = occupied.first();
                int distance = n - 1 - no;
                if (distance > no) {
                    q.offer(new int[]{distance, n - 1});
                    occupied.add(n - 1);
                    return n - 1;
                } else {
                    q.offer(new int[]{no, no});
                    occupied.add(0);
                    return 0;
                }
            } else {
                while (true) {
                    int first = occupied.first();
                    int last = occupied.last();
                    int rd = n - 1 - last;
                    int[] dn = q.peek();
                    int r = dn[1];
                    int l = r - dn[0];
                    if (!occupied.contains(l) || !occupied.contains(r) || occupied.higher(l) != r) {
                        q.poll();
                        continue;
                    }
                    int distance = dn[0] / 2;
                    if (distance <= first || distance < rd) {
                        if (first < rd) {
                            q.offer(new int[]{rd, n - 1});
                            occupied.add(n - 1);
                            return n - 1;
                        } else {
                            q.offer(new int[]{l, l});
                            occupied.add(0);
                            return 0;
                        }
                    } else {
                        q.poll();
                        int m = l + (r - l) / 2;
                        occupied.add(m);
                        q.offer(new int[]{m - l, m});
                        q.offer(new int[]{r - m, r});
                        return m;
                    }
                }
            }
        }

        public void leave(int p) {
            if (p != occupied.first() && p != occupied.last()) {
                int l = occupied.lower(p);
                int r = occupied.higher(p);
                q.offer(new int[]{r - l, r});
            }
            occupied.remove(p);
        }
    }

}
