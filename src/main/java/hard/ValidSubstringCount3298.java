package hard;

/**
 * 统计重新排列后包含另一个字符串的子字符串数目 II
 * <p>
 * 给你两个字符串 word1 和 word2 。
 * 如果一个字符串 x 重新排列后，word2 是重排字符串的 前缀，那么我们称字符串 x 是 合法的 。
 * 请你返回 word1 中 合法 子字符串 的数目。
 * 注意 ，这个问题中的内存限制比其他题目要 小 ，所以你 必须 实现一个线性复杂度的解法。
 *
 * @author jd95288
 * @date 2025-01-10 0:11
 */
public class ValidSubstringCount3298 {

    public long validSubstringCount(String word1, String word2) {
        int[] cnt = new int[26];
        int distinctCharCnt = 0;
        for (int i = 0; i < word2.length(); i++) {
            if (cnt[word2.charAt(i) - 'a']-- == 0) {
                distinctCharCnt++;
            }
        }
        long res = 0;
        int l = 0;
        for (int r = 0; r < word1.length(); r++) {
            if (++cnt[word1.charAt(r) - 'a'] == 0) {
                distinctCharCnt--;
            }
            while (l < word1.length() && distinctCharCnt == 0) {
                res += word1.length() - r;
                if (--cnt[word1.charAt(l++) - 'a'] < 0) {
                    distinctCharCnt++;
                }
            }
        }
        return res;
    }

}
