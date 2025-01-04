package hard;

import java.util.Map;
import java.util.TreeMap;

/**
 * 我的日程安排表 III
 *
 * 当 k 个日程存在一些非空交集时（即, k 个日程包含了一些相同时间），就会产生 k 次预订。
 * 给你一些日程安排 [startTime, endTime) ，请你在每个日程安排添加后，返回一个整数 k ，表示所有先前日程安排会产生的最大 k 次预订。
 * 实现一个 MyCalendarThree 类来存放你的日程安排，你可以一直添加新的日程安排。
 * MyCalendarThree() 初始化对象。
 * int book(int startTime, int endTime) 返回一个整数 k ，表示日历中存在的 k 次预订的最大值。
 *
 * @author jd95288
 * @date 2025-01-04 15:40
 */
public class MyCalendarThree732 {

    static class MyCalendarThree {

        TreeMap<Integer, Integer> cnt = new TreeMap<>();

        public MyCalendarThree() {

        }

        public int book(int startTime, int endTime) {
            cnt.put(startTime, cnt.getOrDefault(startTime, 0) + 1);
            cnt.put(endTime, cnt.getOrDefault(endTime, 0) - 1);
            int res = 0;
            int appearanceCnt = 0;
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                int value = entry.getValue();
                appearanceCnt += value;
                res = Math.max(appearanceCnt, res);
            }
            return res;
        }
    }
}
