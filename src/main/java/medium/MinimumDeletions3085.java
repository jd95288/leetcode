package medium;

import java.util.Arrays;

/**
 * 成为 K 特殊字符串需要删除的最少字符数
 * <p>
 * 给你一个字符串 word 和一个整数 k。
 * 如果 |freq(word[i]) - freq(word[j])| <= k 对于字符串中所有下标 i 和 j  都成立，则认为 word 是 k 特殊字符串。
 * 此处，freq(x) 表示字符 x 在 word 中的出现频率，而 |y| 表示 y 的绝对值。
 * 返回使 word 成为 k 特殊字符串 需要删除的字符的最小数量。
 *
 * @author jd95288
 * @date 2025-06-21 20:58
 */
public class MinimumDeletions3085 {

    public int minimumDeletions(String word, int k) {
        int[] cnt = new int[26];
        char[] chars = word.toCharArray();
        for (char c : chars) {
            cnt[c - 'a']++;
        }
        Arrays.sort(cnt);
        int maxLength = 0;
        int frequency = 0;
        int r = 0;
        for (int l = 0; l < 26; l++) {
            if (cnt[l] == 0) {
                continue;
            }
            while (r < 26 && cnt[l] + k >= cnt[r]) {
                frequency += cnt[r];
                r++;
            }
            maxLength = Math.max(maxLength, frequency + (26 - r) * (cnt[l] + k));
            frequency -= cnt[l];
        }
        return word.length() - maxLength;
    }

}
