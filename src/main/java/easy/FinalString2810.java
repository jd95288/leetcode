package easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * 故障键盘
 * 你的笔记本键盘存在故障，每当你在上面输入字符 'i' 时，它会反转你所写的字符串。而输入其他字符则可以正常工作。
 * 给你一个下标从 0 开始的字符串 s ，请你用故障键盘依次输入每个字符。
 * 返回最终笔记本屏幕上输出的字符串。
 *
 * @author jd95288
 * @date 2024-04-01 8:42
 */
public class FinalString2810 {

    public String finalString_v1(String s) {
        StringBuilder res = new StringBuilder();
        Deque<Character> q = new ArrayDeque<>();
        boolean reverse = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ('i' == ch) {
                reverse = !reverse;
            } else if (reverse) {
                q.push(ch);
            } else {
                q.offer(ch);
            }
        }
        Iterator<Character> it;
        if (reverse) {
            it = q.descendingIterator();
        } else {
            it = q.iterator();
        }
        while (it.hasNext()) {
            res.append(it.next());
        }
        return res.toString();
    }

    public String finalString(String s) {
        StringBuilder res = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ('i' == chars[i]) {
                res.reverse();
            } else {
                res.append(chars[i]);
            }
        }
        return res.toString();
    }
}
