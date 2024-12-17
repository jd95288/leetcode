package medium;

import java.util.Arrays;

/**
 * 形成目标字符串需要的最少字符串数I
 * 有一个字符串数组 words 和目标字符串 target，
 * 请你使用最少的字符串前缀组成 target，返回需要的字符串数量，如果无法组成 target 返回 -1。
 *
 * @author jd95288
 * @date 2024-12-17 8:59
 */
public class MinValidStrings3291 {

    static public class Trie {
        public boolean isLeaf;
        public Trie[] children;

        public Trie() {
            this.children = new Trie[26];
        }

        public Trie build(String[] dict) {
            Trie root = this;
            for (String word : dict) {
                root = this;
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    int c = chars[i] - 'a';
                    if (root.children[c] == null) {
                        root.children[c] = new Trie();
                    }
                    root = root.children[c];
                }
                root.isLeaf = true;
            }
            return root;
        }

        public int exists(char[] target, int start) {
            int n = target.length;
            int length = 0;
            Trie root = this;
            int c = target[start] - 'a';
            while (root.children[c] != null) {
                root = root.children[c];
                length++;
                start++;
                if (start == n) {
                    break;
                }
                c = target[start] - 'a';
            }
            return length;
        }

    }

    public int minValidStrings(String[] words, String target) {
        Trie root = new Trie();
        root.build(words);
        char[] chars = target.toCharArray();
        int n = chars.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int length = root.exists(chars, 0);
        for (int i = 0; i < length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (dp[i - 1] == Integer.MAX_VALUE) {
                return -1;
            }
            length = root.exists(chars, i);
            for (int j = i; j < i + length; j++) {
                dp[j] = Math.min(dp[j], dp[i - 1] + 1);
            }
        }

        return dp[n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1];
    }

}
