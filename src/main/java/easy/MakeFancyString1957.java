package easy;

/**
 * 删除字符使字符串变好
 * <p>
 * 一个字符串如果没有 三个连续 相同字符，那么它就是一个 好字符串 。
 * 给你一个字符串 s ，请你从 s 删除 最少 的字符，使它变成一个 好字符串 。
 * 请你返回删除后的字符串。题目数据保证答案总是 唯一的 。
 *
 * @author jd95288
 * @date 2025-07-21 8:40
 */
public class MakeFancyString1957 {

    public String makeFancyString(String s) {
        int n = s.length();
        char prev = ' ';
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (prev == c) {
                if (cnt < 2) {
                    cnt++;
                    sb.append(c);
                }
            } else {
                sb.append(c);
                prev = c;
                cnt = 1;
            }
        }
        return sb.toString();
    }

}
