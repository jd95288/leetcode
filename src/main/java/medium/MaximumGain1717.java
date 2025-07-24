package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 删除子字符串的最大得分
 *
 * 给你一个字符串 s 和两个整数 x 和 y 。你可以执行下面两种操作任意次。
 * 删除子字符串 "ab" 并得到 x 分。
 * 比方说，从 "cabxbae" 删除 ab ，得到 "cxbae" 。
 * 删除子字符串"ba" 并得到 y 分。
 * 比方说，从 "cabxbae" 删除 ba ，得到 "cabxe" 。
 * 请返回对 s 字符串执行上面操作若干次能得到的最大得分。
 *
 * @author jd95288
 * @date 2025-07-23 9:01
 */
public class MaximumGain1717 {

    public int maximumGain(String s, int x, int y) {
        char prev, cur;
        int max, min;
        if (x > y) {
            prev = 'a';
            cur = 'b';
            max = x;
            min = y;
        } else {
            prev = 'b';
            cur = 'a';
            max = y;
            min = x;
        }
        Deque<Character> q = new ArrayDeque<>();
        q.push('^');
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (q.peek() == prev && c == cur) {
                q.pop();
                res += max;
            } else {
                q.push(c);
            }
        }
        q.removeLast();
        Deque<Character> p = new ArrayDeque<>();
        p.push('^');
        while (!q.isEmpty()) {
            if (q.peekLast() == prev && p.peek() == cur) {
                q.removeLast();
                p.pop();
                res += min;
            } else {
                p.push(q.removeLast());
            }
        }
        return res;
    }

}
