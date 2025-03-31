package medium;

/**
 * 向字符串添加空格
 *
 * 给你一个下标从 0 开始的字符串 s ，以及一个下标从 0 开始的整数数组 spaces 。
 * 数组 spaces 描述原字符串中需要添加空格的下标。每个空格都应该插入到给定索引处的字符值 之前 。
 * 例如，s = "EnjoyYourCoffee" 且 spaces = [5, 9] ，那么我们需要在 'Y' 和 'C' 之前添加空格，这两个字符分别位于下标 5 和下标 9 。
 * 因此，最终得到 "Enjoy Your Coffee" 。
 * 请你添加空格，并返回修改后的字符串。
 *
 * @author jd95288
 * @date 2025-03-30 0:08
 */
public class AddSpaces2109 {

    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s.length() + spaces.length);
        int start = 0;
        for (int i : spaces) {
            sb.append(s, start, i).append(' ');
            start = i;
        }
        sb.append(s.substring(start));
        return sb.toString();
    }
}
