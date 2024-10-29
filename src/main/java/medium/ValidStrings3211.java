package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成不含相邻零的二进制字符串
 * <p>
 * 给你一个正整数 n。
 * 如果一个二进制字符串 x 的所有长度为 2 的 子字符串 中包含 至少 一个 "1"，则称 x 是一个 有效 字符串。
 * 返回所有长度为 n 的 有效 字符串，可以以任意顺序排列。
 *
 * @author jd95288
 * @date 2024-10-29 0:23
 */
public class ValidStrings3211 {

    List<String> res;
    char[] path;
    int n;

    public List<String> validStrings(int n) {
        res = new ArrayList<>();
        path = new char[n];
        this.n = n;
        backTracing('1', 0);
        return res;
    }

    public void backTracing(char prev, int i) {
        if (i == n) {
            res.add(new String(path));
            return;
        }
        path[i] = '1';
        int next = i + 1;
        backTracing('1', next);
        if (prev != '0') {
            path[i] = '0';
            backTracing('0', next);
        }
    }
}
