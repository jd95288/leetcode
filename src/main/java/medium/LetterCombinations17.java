package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * @author jd95288
 * @date 2024-10-12 15:57
 */
public class LetterCombinations17 {


    static String[] g = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() > 0) {
            StringBuilder sb = new StringBuilder();
            dfs(digits, 0, res, sb);
        }
        return res;
    }

    public void dfs(String digits, int index, List<String> res, StringBuilder sb) {
        if (digits.length() == index) {
            res.add(sb.toString());
            return;
        }
        int num = digits.charAt(index) - '0';
        for (char c : g[num].toCharArray()) {
            sb.append(c);
            dfs(digits, index + 1, res, sb);
            sb.deleteCharAt(index);
        }
    }

}
