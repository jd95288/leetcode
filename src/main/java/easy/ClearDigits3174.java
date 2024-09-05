package easy;


/**
 * 清除数字
 * <p>
 * 给你一个字符串 s 。
 * 你的任务是重复以下操作删除 所有 数字字符：
 * - 删除 第一个数字字符 以及它左边 最近 的 非数字 字符。
 * 请你返回删除所有数字字符以后剩下的字符串。
 *
 * @author jd95288
 * @date 2024-09-05 8:47
 */
public class ClearDigits3174 {

    public String clearDigits_v1(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c > '9' || c < '0') {
                sb.append(c);
            } else {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

}
