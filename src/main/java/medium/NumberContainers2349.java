package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 设计数字容器系统
 * <p>
 * 设计一个数字容器系统，可以实现以下功能：
 * <p>
 * 在系统中给定下标处 插入 或者 替换 一个数字。
 * 返回 系统中给定数字的最小下标。
 * <p>
 * 请你实现一个 NumberContainers 类：
 * NumberContainers() 初始化数字容器系统。
 * void change(int index, int number) 在下标 index 处填入 number 。如果该下标 index 处已经有数字了，那么用 number 替换该数字。
 * int find(int number) 返回给定数字 number 在系统中的最小下标。如果系统中没有 number ，那么返回 -1 。
 *
 * @author jd95288
 * @date 2025-09-17 8:48
 */
public class NumberContainers2349 {

    class NumberContainers {

        private final Map<Integer, Integer> indexToValue;
        private final Map<Integer, PriorityQueue<Integer>> valueToIndex;

        public NumberContainers() {
            indexToValue = new HashMap<>();
            valueToIndex = new HashMap<>();
        }

        public void change(int index, int number) {
            indexToValue.put(index, number);
            valueToIndex.putIfAbsent(number, new PriorityQueue<>());
            valueToIndex.get(number).offer(index);
        }

        public int find(int number) {
            PriorityQueue<Integer> q = valueToIndex.get(number);
            if (q == null) {
                return -1;
            }
            while (!q.isEmpty() && indexToValue.get(q.peek()) != number) {
                q.poll();
            }
            return q.isEmpty() ? -1 : q.peek();
        }
    }

}
