package medium;


/**
 * 最长特殊序列 II
 * <p>
 * 给定字符串列表 strs ，返回其中 最长的特殊序列 的长度。如果最长特殊序列不存在，返回 -1 。
 * 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。
 * s 的 子序列可以通过删去字符串 s 中的某些字符实现。
 * 例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。
 * "aebdc"的子序列还包括"aebdc"、 "aeb" 和 "" (空字符串)。
 *
 * @author jd95288
 * @date 2024-06-17 8:38
 */
public class FindLUSlength522 {

    public boolean isSubSequence(String s, String t) {
        int l = t.length();
        int sl = s.length();
        int j = 0;
        for (int i = 0; i < l; i++) {
            if (s.charAt(j) == t.charAt(i) && ++j == sl) {
                return true;
            }
        }
        return false;
    }

    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int res = -1;
        next:
        for (int i = 0; i < n; i++) {
            String preStr = strs[i];
            int preLen = preStr.length();
            if (res >= preLen) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                String curStr = strs[j];
                if (j != i && isSubSequence(preStr, curStr)) {
                    continue next;
                }
            }
            res = Math.max(res, preLen);
        }
        return res;
    }

}
