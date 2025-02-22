package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计相似字符串对的数目
 * <p>
 * 给你一个下标从 0 开始的字符串数组 words 。
 * 如果两个字符串由相同的字符组成，则认为这两个字符串 相似 。
 * 例如，"abca" 和 "cba" 相似，因为它们都由字符 'a'、'b'、'c' 组成。
 * 然而，"abacba" 和 "bcfd" 不相似，因为它们不是相同字符组成的。
 * 请你找出满足字符串 words[i] 和 words[j] 相似的下标对 (i, j) ，并返回下标对的数目，其中 0 <= i < j <= words.length - 1 。
 *
 * @author jd95288
 * @date 2025-02-22 12:06
 */
public class SimilarPairs2506 {

    public int similarPairs(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int mask = 0;
            int length = word.length();
            for (int i = 0; i < length; i++) {
                int offset = word.charAt(i) - 'a';
                mask |= 1 << offset;
            }
            map.merge(mask, 1, Integer::sum);
        }
        return map.values().stream().mapToInt(x -> x * (x - 1) / 2).sum();
    }

}
