package medium;

import java.util.*;

/**
 * 元音辅音字符串计数 II
 * <p>
 * 给你一个字符串 word 和一个 非负 整数 k。
 * 返回 word 的 子字符串 中，每个元音字母（'a'、'e'、'i'、'o'、'u'）至少 出现一次，
 * 并且 恰好 包含 k 个辅音字母的子字符串的总数。
 *
 * @author jd95288
 * @date 2025-03-13 17:03
 */
public class CountOfSubstrings3306 {

    public long countOfSubstrings(String word, int k) {
        return slidingWindow(word, k) - slidingWindow(word, k + 1);
    }

    public long slidingWindow(String word, int k) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        Map<Character, Integer> map = new HashMap<>();
        int n = word.length();
        int consonantCnt = 0;
        long res = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            char c = word.charAt(right);
            if (vowels.contains(c)) {
                Integer cnt = map.getOrDefault(c, 0);
                map.put(c, cnt + 1);
            } else {
                consonantCnt++;
            }
            while (left <= right && consonantCnt >= k && map.size() == 5) {
                c = word.charAt(left++);
                if (vowels.contains(c)) {
                    map.merge(c, -1, Integer::sum);
                    if (map.get(c) == 0) {
                        map.remove(c);
                    }
                } else {
                    consonantCnt--;
                }

            }
            res += left;
        }
        return res;
    }
}
