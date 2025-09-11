package medium;

import java.util.Arrays;

/**
 * 将字符串中的元音字母排序
 * <p>
 * 给你一个下标从 0 开始的字符串 s ，将 s 中的元素重新 排列 得到新的字符串 t ，它满足：
 * 所有辅音字母都在原来的位置上。更正式的，如果满足 0 <= i < s.length 的下标 i 处的 s[i] 是个辅音字母，那么 t[i] = s[i] 。
 * 元音字母都必须以他们的 ASCII 值按 非递减 顺序排列。更正式的，对于满足 0 <= i < j < s.length 的下标 i 和 j  ，如果 s[i] 和 s[j] 都是元音字母，那么 t[i] 的 ASCII 值不能大于 t[j] 的 ASCII 值。
 * 请你返回结果字母串。
 * 元音字母为 'a' ，'e' ，'i' ，'o' 和 'u' ，它们可能是小写字母也可能是大写字母，辅音字母是除了这 5 个字母以外的所有字母。
 *
 * @author jd95288
 * @date 2025-09-11 9:26
 */
public class SortVowels2785 {

    public static boolean[] isVowel = new boolean[26];

    static {
        isVowel[0] = true;
        isVowel['e' - 'a'] = true;
        isVowel['i' - 'a'] = true;
        isVowel['o' - 'a'] = true;
        isVowel['u' - 'a'] = true;
    }

    public String sortVowels(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (isVowel[Character.toLowerCase(c) - 'a']) {
                sb.append(c);
            }
        }
        char[] vowels = sb.toString().toCharArray();
        Arrays.sort(vowels);
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            if (isVowel[Character.toLowerCase(chars[i]) - 'a']) {
                chars[i] = vowels[j++];
            }
        }
        return new String(chars);
    }

}
