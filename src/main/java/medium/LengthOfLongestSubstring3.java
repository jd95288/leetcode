package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串的长度。
 *
 * @author jd95288
 * @date 2024-05-05 20:35
 */
public class LengthOfLongestSubstring3 {
    public int lengthOfLongestSubstring(String s) {
        char[] c = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        // 字串长度
        int l = 0;
        for (int i = 0; i < c.length; i++) {
            if (map.get(c[i]) == null) {
                map.put(c[i], i);
                l++;
                res = Math.max(res, l);
            } else {
                res = Math.max(res, l);
                l = i - map.get(c[i]);
                map.clear();
                for (int j = i - l + 1; j <= i; j++) {
                    map.put(c[j], j);
                }
            }
        }
        return res;
    }
}
