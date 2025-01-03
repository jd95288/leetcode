package medium;

import java.util.*;

/**
 * 我的日程安排表II
 *
 * 实现一个程序来存放你的日程安排。如果要添加的时间内不会导致三重预订时，则可以存储这个新的日程安排。
 * 当三个日程安排有一些时间上的交叉时（例如三个日程安排都在同一时间内），就会产生 三重预订。
 * 事件能够用一对整数 startTime 和 endTime 表示，在一个半开区间的时间 [startTime, endTime) 上预定。
 * 实数 x 的范围为  startTime <= x < endTime。
 * 实现 MyCalendarTwo 类：
 * - MyCalendarTwo() 初始化日历对象。
 * - boolean book(int startTime, int endTime) 如果可以将日程安排成功添加到日历中而不会导致三重预订，返回 true。
 * 否则，返回 false 并且不要将该日程安排添加到日历中。
 *
 * @author jd95288
 * @date 2025-01-03 10:32
 */
public class MyCalendarTwo731 {

    static class MyCalendarTwo {

        TreeMap<Integer, Integer> cnt = new TreeMap<>();

        public MyCalendarTwo() {

        }

        public boolean book(int startTime, int endTime) {
            cnt.put(startTime, cnt.getOrDefault(startTime, 0) + 1);
            cnt.put(endTime, cnt.getOrDefault(endTime, 0) - 1);
            int appearanceCnt = 0;
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                if (key >= endTime) {
                    break;
                }
                appearanceCnt += value;
                if (appearanceCnt > 2) {
                    cnt.put(startTime, cnt.getOrDefault(startTime, 0) - 1);
                    cnt.put(endTime, cnt.getOrDefault(endTime, 0) + 1);
                    return false;
                }
            }
            return true;
        }
    }


}
