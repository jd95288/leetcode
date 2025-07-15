package easy;

import java.util.regex.Pattern;

/**
 * 有效单词
 *
 * 有效单词 需要满足以下几个条件：
 * 至少 包含 3 个字符。
 * 由数字 0-9 和英文大小写字母组成。（不必包含所有这类字符。）
 * 至少 包含一个 元音字母 。
 * 至少 包含一个 辅音字母 。
 * 给你一个字符串 word 。如果 word 是一个有效单词，则返回 true ，否则返回 false 。
 *
 * 注意：
 * 'a'、'e'、'i'、'o'、'u' 及其大写形式都属于 元音字母 。
 * 英文中的 辅音字母 是指那些除元音字母之外的字母。
 *
 * @author jd95288
 * @date 2025-07-15 8:52
 */
public class IsValid3136 {

    public static Pattern p = Pattern.compile("^(?=.*[aeiouAEIOU])(?=.*[b-df-hj-np-tv-zB-DF-HJ-NP-TV-Z])[0-9a-zA-z]{3,}$");

    public boolean isValid(String word) {
        return p.matcher(word).find();
    }

}
