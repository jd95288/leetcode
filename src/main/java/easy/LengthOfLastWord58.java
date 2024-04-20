package easy;

/**
 * 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 * @author jd95288
 * @date 2024-04-20 21:58
 */
public class LengthOfLastWord58 {

    /** 可能出错的点就是忘记处理结尾开始的空格以及下标计算*/
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int i, j = 0;
        for (i = chars.length - 1; i >= 0; i--) {
            if (i != chars.length - 1 && 32 != chars[i + 1] && 32 == chars[i]) {
                break;
            } else if (32 == chars[i]) {
                j++;
            }
        }
        return chars.length - i - j - 1;
    }
}
