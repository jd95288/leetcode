package medium;

/**
 * 生成特殊数字的最少操作
 * <p>
 * 给你一个下标从 0 开始的字符串 num ，表示一个非负整数。
 * 在一次操作中，您可以选择 num 的任意一位数字并将其删除。请注意，如果你删除 num 中的所有数字，则 num 变为 0。
 * 返回最少需要多少次操作可以使 num 变成特殊数字。
 * 如果整数 x 能被 25 整除，则该整数 x 被认为是特殊数字。
 *
 * @author jd95288
 * @date 2024-07-25 11:17
 */
public class MinimumOperations2844 {


    public int minimumOperations(String num) {
        int n = num.length();
        int res = 0;
        int cursor = n - 1;
        while (cursor >= 0 && num.charAt(cursor) != '0') {
            cursor--;
        }
        res = n - 1 - cursor;
        cursor--;
        while (cursor >= 0 && (num.charAt(cursor) != '0' && num.charAt(cursor) != '5')) {
            cursor--;
            res++;
        }

        int res5 = 0;
        cursor = n - 1;
        while (cursor >= 0 && num.charAt(cursor) != '5') {
            cursor--;
        }
        res5 = n - 1 - cursor;
        cursor--;
        while (cursor >= 0 && (num.charAt(cursor) != '2' && num.charAt(cursor) != '7')) {
            cursor--;
            res5++;
        }
        if (cursor < 0) {
            res5++;
        }
        return Math.min(res, res5);
    }

}
