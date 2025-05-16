package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最长相邻不相等子序列 II
 * <p>
 * 给你一个整数 n 和一个下标从 0 开始的字符串数组 words ，和一个下标从 0 开始的数组 groups ，两个数组长度都是 n 。
 * 两个长度相等字符串的 汉明距离 定义为对应位置字符 不同 的数目。
 * 你需要从下标 [0, 1, ..., n - 1] 中选出一个 最长子序列 ，将这个子序列记作长度为 k 的 [i0, i1, ..., ik - 1] ，它需要满足以下条件：
 * 相邻 下标对应的 groups 值 不同。即，对于所有满足 0 < j + 1 < k 的 j 都有 groups[ij] != groups[ij + 1] 。
 * 对于所有 0 < j + 1 < k 的下标 j ，都满足 words[ij] 和 words[ij + 1] 的长度 相等 ，且两个字符串之间的 汉明距离 为 1 。
 * 请你返回一个字符串数组，它是下标子序列 依次 对应 words 数组中的字符串连接形成的字符串数组。如果有多个答案，返回任意一个。
 * 子序列 指的是从原数组中删掉一些（也可能一个也不删掉）元素，剩余元素不改变相对位置得到的新的数组。
 * 注意：words 中的字符串长度可能 不相等 。
 *
 * @author jd95288
 * @date 2025-05-15 11:15
 */
public class GetWordsInLongestSubsequence2901 {

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        List<String>[] dp = new ArrayList[n];
        Arrays.setAll(dp, x -> new ArrayList<>());
        for (int i = 0; i < dp.length; i++) {
            dp[i].add(words[i]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] && check(words[i], words[j])) {
                    if (dp[j].size() >= dp[i].size()) {
                        dp[i] = new ArrayList<>(dp[j]);
                        dp[i].add(words[i]);
                    }
                }
            }
        }
        for (List<String> list : dp) {
            if (list.size() > res.size()) {
                res = list;
            }
        }
        return res;
    }

    public boolean check(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int cnt = 0;
        int n = word1.length();
        for (int i = 0; i < n; i++) {
            if (cnt > 1) {
                return false;
            }
            if (word1.charAt(i) != word2.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }

}
