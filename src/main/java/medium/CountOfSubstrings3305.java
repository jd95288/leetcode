package medium;


import java.util.*;

/**
 * 元音辅音字符串计数 I
 * <p>
 * 给你一个字符串 word 和一个 非负 整数 k。
 * 返回 word 的 子字符串 中，每个元音字母（'a'、'e'、'i'、'o'、'u'）至少 出现一次，
 * 并且 恰好 包含 k 个辅音字母的子字符串的总数。
 *
 * @author jd95288
 * @date 2025-03-12 8:42
 */
public class CountOfSubstrings3305 {

    public int countOfSubstrings(String word, int k) {
        int n = word.length();
        Set<Character> vowel = new HashSet<>();
        Collections.addAll(vowel, 'a', 'e', 'i', 'o', 'u');
        Map<Character, Integer> map = new HashMap<>();
        int consonantCnt = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                char c = word.charAt(j);
                if (vowel.contains(c)) {
                    Integer cnt = map.getOrDefault(c, 0);
                    map.put(c, cnt + 1);
                } else {
                    consonantCnt++;
                }
                if (consonantCnt == k && map.size() == 5) {
                    res++;
                } else if (consonantCnt > k) {
                    break;
                }
            }
            map.clear();
            consonantCnt = 0;
        }
        return res;
    }

}
