package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 可以输入的最大单词数
 *
 * 键盘出现了一些故障，有些字母键无法正常工作。而键盘上所有其他键都能够正常工作。
 * 给你一个由若干单词组成的字符串 text ，单词间由单个空格组成（不含前导和尾随空格）；
 * 另有一个字符串 brokenLetters ，由所有已损坏的不同字母键组成，返回你可以使用此键盘完全输入的 text 中单词的数目。
 *
 * @author jd95288
 * @date 2025-09-15 8:46
 */
public class CanBeTypedWords1935 {

    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> brokenSet = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) {
            brokenSet.add(c);
        }
        String[] words = text.split(" ");
        int res = words.length;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (brokenSet.contains(c)){
                    res--;
                    break;
                }
            }
        }
        return res;
    }
}
