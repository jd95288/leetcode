package medium;

/**
 * 实现 Trie (前缀树)
 *
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。
 * 这一数据结构有相当多的应用情景，例如自动补全和拼写检查。
 *
 * 请你实现 Trie 类：
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 *
 * @author jd95288
 * @date 2024-08-24 21:35
 */
public class Trie208 {

    class Trie {

        private final Trie[] subTrie;
        private boolean isLeaf;

        public Trie() {
            subTrie = new Trie[26];
        }

        public void insert(String word) {
            int n = word.length();
            Trie r = this;
            for (int i = 0; i < n; i++) {
                int c = word.charAt(i) - 'a';
                if (r.subTrie[c] == null) {
                    r.subTrie[c] = new Trie();
                }
                r = r.subTrie[c];
            }
            r.isLeaf = true;
        }

        public boolean search(String word) {
            Trie node = dfs(word, this, 0);
            return node !=null && node.isLeaf;
        }


        public boolean startsWith(String prefix) {
            return dfs(prefix, this, 0) != null;
        }

        private Trie dfs(String searchWord, Trie node, int pos) {
            if (searchWord.length() == pos) {
                // search 是完全匹配，需要判断是否是叶子节点
                return node;
            }
            int c = searchWord.charAt(pos) - 'a';
            if (node.subTrie[c] != null) {
                return dfs(searchWord, node.subTrie[c], pos + 1);
            }
            return null;
        }

    }
}
