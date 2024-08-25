package medium;

/**
 * 添加与搜索单词 - 数据结构设计
 *
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 * 实现词典类 WordDictionary ：
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；
 * 否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 *
 * @author jd95288
 * @date 2024-08-25 22:34
 */
public class WordDictionary211 {

    /**
     * 这个与 Trie208 的区别在于 多了正则匹配 .表示任意一个字符
     * 执行通过
     */
    class WordDictionary {

        private final WordDictionary[] subTrie;
        private boolean isLeaf;

        public WordDictionary() {
            subTrie = new WordDictionary[26];
        }

        public void addWord(String word) {
            int n = word.length();
            WordDictionary r = this;
            for (int i = 0; i < n; i++) {
                int c = word.charAt(i) - 'a';
                if (r.subTrie[c] == null) {
                    r.subTrie[c] = new WordDictionary();
                }
                r = r.subTrie[c];
            }
            r.isLeaf = true;
        }

        public boolean search(String word) {
            return dfs(word, this, 0);
        }

        private boolean dfs(String searchWord, WordDictionary node, int pos) {
            if (searchWord.length() == pos) {
                return node.isLeaf;
            }
            int c = searchWord.charAt(pos) - 'a';
            if (searchWord.charAt(pos) != '.') {
                if (node.subTrie[c] != null) {
                    return dfs(searchWord, node.subTrie[c], pos + 1);
                }
            } else {
                for (int i = 0; i < 26; i++) {
                    if (node.subTrie[i] != null && dfs(searchWord, node.subTrie[i], pos + 1)) {
                        return true;
                    }
                }
            }
            return false;
        }

    }
}
