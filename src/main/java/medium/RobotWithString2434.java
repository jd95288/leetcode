package medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

/**
 * 使用机器人打印字典序最小的字符串
 * <p>
 * 给你一个字符串 s 和一个机器人，机器人当前有一个空字符串 t 。执行以下操作之一，直到 s 和 t 都变成空字符串：
 * 删除字符串 s 的 第一个 字符，并将该字符给机器人。机器人把这个字符添加到 t 的尾部。
 * 删除字符串 t 的 最后一个 字符，并将该字符给机器人。机器人将该字符写到纸上。
 * 请你返回纸上能写出的字典序最小的字符串。
 *
 * @author jd95288
 * @date 2025-06-06 8:47
 */
public class RobotWithString2434 {

    public String robotWithString(String s) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (char c : chars) {
            map.merge(c, 1, Integer::sum);
        }
        ArrayDeque<Character> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < n) {
            Character min = map.firstKey();
            while (i < n && chars[i] != min) {
                char c = chars[i++];
                q.offer(c);
                map.merge(c, -1, Integer::sum);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
            }
            sb.append(min);
            map.merge(min, -1, Integer::sum);
            if (map.get(min) == 0) {
                map.remove(min);
            }
            i++;
            while (!q.isEmpty() && (map.size() == 0 || q.peekLast() <= map.firstKey())) {
                sb.append(q.pollLast());
            }
        }
        return sb.toString();
    }

}
