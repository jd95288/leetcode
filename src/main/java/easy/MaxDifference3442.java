package easy;

/**
 * 奇偶频次间的最大差值 I
 * <p>
 * 给你一个由小写英文字母组成的字符串 s 。
 * 请你找出字符串中两个字符 a1 和 a2 的出现频次之间的 最大 差值 diff = a1 - a2，这两个字符需要满足：
 * a1 在字符串中出现 奇数次 。
 * a2 在字符串中出现 偶数次 。
 * 返回 最大 差值。
 *
 * @author jd95288
 * @date 2025-06-10 8:42
 */
public class MaxDifference3442 {

    public int maxDifference(String s) {
        int[] cnt = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            cnt[c - 'a']++;
        }
        int oddMax = 0;
        int evenMin = Integer.MAX_VALUE;
        for (int i : cnt) {
            if (i == 0) {
                continue;
            }
            if (i % 2 == 1) {
                oddMax = Math.max(i, oddMax);
            } else {
                evenMin = Math.min(i, evenMin);
            }
        }
        return oddMax - evenMin;
    }
}
