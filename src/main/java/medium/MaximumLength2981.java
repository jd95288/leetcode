package medium;

import java.util.*;

/**
 * 找出出现至少三次的最长特殊子字符串 I
 * <p>
 * 给你一个仅由小写英文字母组成的字符串 s 。
 * 如果一个字符串仅由单一字符组成，那么它被称为 特殊 字符串。
 * 例如，字符串 "abc" 不是特殊字符串，而字符串 "ddd"、"zz" 和 "f" 是特殊字符串。
 * 返回在 s 中出现 至少三次 的 最长特殊子字符串 的长度，如果不存在出现至少三次的特殊子字符串，则返回 -1 。
 * 子字符串 是字符串中的一个连续 非空 字符序列。
 *
 * @author jd95288
 * @date 2024-05-29 8:42
 */
public class MaximumLength2981 {
    public int maximumLength(String s) {
        int res = -1;
        Map<Character, List<Integer>> map = new HashMap<>(26);
        for (int i = 'a'; i <= 'z'; i++) {
            map.put((char) i, new ArrayList<>());
        }
        int n = s.length();
        char last = s.charAt(0);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == last) {
                cnt++;
            } else {
                map.get(last).add(cnt);
                cnt = 1;
                last = c;
            }
            if (i == n - 1) {
                map.get(c).add(cnt);
            }
        }
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            List<Integer> occurrence = entry.getValue();
            int size = occurrence.size();
            Collections.sort(occurrence);
            if (size >= 2) {
                Integer firstOccurrence = occurrence.get(size - 2);
                Integer lastOccurrence = occurrence.get(size - 1);
                if (lastOccurrence - firstOccurrence >= 1) {
                    res = Math.max(res, Math.max(firstOccurrence, lastOccurrence - 2));
                } else {
                    res = Math.max(res, lastOccurrence - 1);
                }
                if (size >= 3) {
                    res = Math.max(res, Math.max(occurrence.get(size - 3), occurrence.get(size - 1) - 2));
                }
            } else if (size == 1) {
                res = Math.max(res, occurrence.get(0) - 2);
            }
        }
        return res == 0 ? -1 : res;
    }

}
