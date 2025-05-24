package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 查找包含给定字符的单词
 * <p>
 * 给你一个下标从 0 开始的字符串数组 words 和一个字符 x 。
 * 请你返回一个 下标数组 ，表示下标在数组中对应的单词包含字符 x 。
 * 注意 ，返回的数组可以是 任意 顺序。
 *
 * @author jd95288
 * @date 2025-05-24 10:09
 */
public class FindWordsContaining2942 {

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>(words.length);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == x) {
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }

}
