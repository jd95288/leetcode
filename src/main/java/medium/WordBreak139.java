package medium;

import java.util.List;

/**
 * 单词拆分
 * <p>
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。
 * 如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 * @author jd95288
 * @date 2024-06-23 19:58
 */
public class WordBreak139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                int length = word.length();
                int lastIndex = i - length;
                if (length <= i && dp[lastIndex] && s.startsWith(word, lastIndex)) {
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }

}
