package medium;

/**
 * 统计重新排列后包含另一个字符串的子字符串数目I
 * <p>
 * 给你两个字符串 word1 和 word2 。
 * 如果一个字符串 x 重新排列后，word2 是重排字符串的 前缀，那么我们称字符串 x 是 合法的 。
 * 请你返回 word1 中 合法 子字符串 的数目。
 *
 * @author jd95288
 * @date 2025-01-09 14:28
 */
public class ValidSubstringCount3297 {

    public long validSubstringCount_v1(String word1, String word2) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        for (char c : chars1) {
            cnt1[c - 'a']++;
        }
        for (char c : chars2) {
            cnt2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] < cnt2[i]) {
                return 0;
            }
        }
        int n = word1.length();
        int r = n - 1;
        while (--cnt1[chars1[r] - 'a'] >= cnt2[chars1[r] - 'a']) {
            r--;
        }
        long res = n - r;
        cnt1[chars1[r++] - 'a']++;
        for (int i = 0; i < n - word2.length(); i++) {
            int c = chars1[i] - 'a';
            cnt1[c]--;
            while (r < n && cnt1[c] < cnt2[c]) {
                cnt1[chars1[r++] - 'a']++;
            }
            if (cnt1[c] >= cnt2[c]) {
                res += n - r + 1;
            } else {
                break;
            }
        }
        return res;
    }

}
