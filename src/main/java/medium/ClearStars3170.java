package medium;

import java.util.*;

/**
 * 删除星号以后字典序最小的字符串
 * <p>
 * 给你一个字符串 s 。它可能包含任意数量的 '*' 字符。你的任务是删除所有的 '*' 字符。
 * 当字符串还存在至少一个 '*' 字符时，你可以执行以下操作：
 * 删除最左边的 '*' 字符，同时删除该星号字符左边一个字典序 最小 的字符。如果有多个字典序最小的字符，你可以删除它们中的任意一个。
 * 请你返回删除所有 '*' 字符以后，剩余字符连接而成的 字典序最小 的字符串。
 *
 * @author jd95288
 * @date 2025-06-07 9:37
 */
public class ClearStars3170 {

    public String clearStars(String s) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            int compare = a[0] - b[0];
            if (compare != 0) {
                return compare;
            }
            return b[1] - a[1];
        });
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            char c = chars[i];
            if (c != '*') {
                q.offer(new int[]{c, i});
            } else {
                q.poll();
            }
        }
        char[] res = new char[q.size()];
        PriorityQueue<int[]> tmp = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        tmp.addAll(q);
        int i = 0;
        while (!tmp.isEmpty()) {
            int[] c = tmp.poll();
            res[i++] = (char) c[0];
        }
        return new String(res);
    }
}
