package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 连接两字母单词得到的最长回文串
 * <p>
 * 给你一个字符串数组 words 。words 中每个元素都是一个包含 两个 小写英文字母的单词。
 * 请你从 words 中选择一些元素并按 任意顺序 连接它们，并得到一个 尽可能长的回文串 。每个元素 至多 只能使用一次。
 * 请你返回你能得到的最长回文串的 长度 。如果没办法得到任何一个回文串，请你返回 0 。
 * 回文串 指的是从前往后和从后往前读一样的字符串。
 *
 * @author jd95288
 * @date 2025-05-25 1:03
 */
public class LongestPalindrome2131 {

    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            char a = word.charAt(0);
            char b = word.charAt(1);
            map.merge(a + String.valueOf(b), 1, Integer::sum);
        }
        int res = 0;
        int centerCnt = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            char a = key.charAt(0);
            char b = key.charAt(1);
            if (a == b) {
                Integer cnt = entry.getValue();
                if (cnt % 2 == 1) {
                    res += centerCnt / 2 * 4;
                    centerCnt = cnt;
                } else {
                    res += cnt / 2 * 4;
                }
            } else {
                int cnt = Math.min(entry.getValue(), map.getOrDefault(b + String.valueOf(a), 0));
                res += cnt * 4;
            }
            entry.setValue(0);
        }
        return res + centerCnt * 2;
    }

}
