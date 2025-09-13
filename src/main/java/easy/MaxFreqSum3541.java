package easy;

/**
 * 找到频率最高的元音和辅音
 * <p>
 * 给你一个由小写英文字母（'a' 到 'z'）组成的字符串 s。
 * 你的任务是找出出现频率 最高 的元音（'a'、'e'、'i'、'o'、'u' 中的一个）和出现频率最高的辅音（除元音以外的所有字母），并返回这两个频率之和。
 * 注意：如果有多个元音或辅音具有相同的最高频率，可以任选其中一个。如果字符串中没有元音或没有辅音，则其频率视为 0。
 * 一个字母 x 的 频率 是它在字符串中出现的次数。
 *
 * @author jd95288
 * @date 2025-09-13 22:46
 */
public class MaxFreqSum3541 {

    /**
     * 网友题解
     * 位运算判断是否是元音
     * 2^0 + 2^4 + 2^8 + 2^14 + 2^20 = 1065233
     * 即十六进制的 0x104111
     * maxCnt[1] 记录元音最大值，maxCnt[0] 记录辅音最大值
     */
    class Solution {
        public int maxFreqSum_v1(String s) {
            final int VOWEL_MASK = 0x104111;
            int[] cnt = new int[26];
            int[] maxCnt = new int[2];
            for (char ch : s.toCharArray()) {
                ch -= 'a';
                int bit = VOWEL_MASK >> ch & 1;
                cnt[ch]++;
                maxCnt[bit] = Math.max(maxCnt[bit], cnt[ch]);
            }
            return maxCnt[0] + maxCnt[1];
        }

        public int maxFreqSum(String s) {
            int[] cnt = new int[26];
            int maxVowelCnt = 0;
            int maxConsonantCnt = 0;
            for (char ch : s.toCharArray()) {
                cnt[ch - 'a']++;
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    maxVowelCnt = Math.max(maxVowelCnt, cnt[ch - 'a']);
                } else {
                    maxConsonantCnt = Math.max(maxConsonantCnt, cnt[ch - 'a']);
                }
            }
            return maxVowelCnt + maxConsonantCnt;
        }

    }


    /**
     * 执行通过
     * 元音字母反向计数
     * 辅音字母正向计数
     * 用最大值减最小值即可，需要特殊处理 max 小于 0，以及 min 大于 0 的情况，说明不存在辅音或元音
     */
    public int maxFreqSum(String s) {
        int[] cnt = new int[26];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                cnt[i]--;
                min = Math.min(min, cnt[i]);
            } else {
                cnt[i]++;
                max = Math.max(max, cnt[i]);
            }
        }
        return Math.max(0, max) - Math.min(0, min);
    }
}
