package medium;

/**
 * 实现一个魔法字典
 * <p>
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。
 * 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
 * 实现 MagicDictionary 类：
 * - MagicDictionary() 初始化对象
 * - void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
 * - bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。
 *
 * @author jd95288
 * @date 2024-08-12 9:08
 */
public class MagicDictionary676 {

    private String[] dictionary;

    public MagicDictionary676() {

    }

    public void buildDict(String[] dictionary) {
        this.dictionary = dictionary;
    }

    public boolean search(String searchWord) {
        for (String word : dictionary) {
            int length = searchWord.length();
            if (word.length() != length) {
                continue;
            }
            int cnt = 0;
            for (int i = 0; i < length; i++) {
                if (word.charAt(i) != searchWord.charAt(i)) {
                    cnt++;
                }
                if (cnt > 1) {
                    break;
                }
            }
            if (cnt == 1) {
                return true;
            }
        }
        return false;
    }
}

