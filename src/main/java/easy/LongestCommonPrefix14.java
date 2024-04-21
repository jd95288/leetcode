package easy;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * @author jd95288
 * @date 2024-04-21 20:02
 */
public class LongestCommonPrefix14 {
    public String longestCommonPrefix(String[] strs) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            min = Math.min(strs[i].length(), min);
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < min; j++) {
            boolean equal = true;
            char c = strs[0].charAt(j);
            for (int i = 0; i < strs.length; i++) {
                if (c != strs[i].charAt(j)) {
                    equal = false;
                    break;
                }
            }
            if (equal) {
                sb.append(c);
            } else {
                return sb.toString();
            }
        }
        return sb.toString();
    }
}
