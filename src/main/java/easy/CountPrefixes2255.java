package easy;

/**
 * 统计是给定字符串前缀的字符串数目
 * <p>
 * 给你一个字符串数组 words 和一个字符串 s ，其中 words[i] 和 s 只包含 小写英文字母 。
 * 请你返回 words 中是字符串 s 前缀 的 字符串数目 。
 * 一个字符串的 前缀 是出现在字符串开头的子字符串。子字符串 是一个字符串中的连续一段字符序列。
 *
 * @author jd95288
 * @date 2025-03-24 8:44
 */
public class CountPrefixes2255 {

    public int countPrefixes(String[] words, String s) {
        int res = 0;
        for (String word : words) {
            if (word.length() > s.length()){
                continue;
            }
            int cnt = 1;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != s.charAt(i)) {
                    cnt = 0;
                    break;
                }
            }
            res += cnt;
        }
        return res;
    }
}
