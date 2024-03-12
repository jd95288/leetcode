package easy;

/**
 * 将标题首字母大写
 * 给你一个字符串 title ，它由单个空格连接一个或多个单词组成，每个单词都只包含英文字母。请你按以下规则将每个单词的首字母 大写 ：
 * 如果单词的长度为 1 或者 2 ，所有字母变成小写。
 * 否则，将单词首字母大写，剩余字母变成小写。
 * 请你返回 大写后 的 title 。
 *
 * @author jd95288
 * @date 2024-03-11 0:16
 */
public class CapitalizeTitle {

    public String capitalizeTitle(String title) {
        char[] chars = title.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char first = (char) i++;
            int counter = 1;
            while (i < chars.length && chars[i] != 32) {
                if (chars[i] < 97) {
                    chars[i] = (char) (chars[i] + 32);
                }
                i++;
                counter++;
            }
            if (counter > 2) {
                if (chars[first] >= 97) {
                    chars[first] = (char) (chars[first] - 32);
                }
            } else {
                if (chars[first] < 97) {
                    chars[first] = (char) (chars[first] + 32);
                }
            }
        }
        return new String(chars);
    }

}
