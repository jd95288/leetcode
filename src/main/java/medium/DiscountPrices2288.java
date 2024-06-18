package medium;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 价格减免
 * <p>
 * 句子 是由若干个单词组成的字符串，单词之间用单个空格分隔，其中每个单词可以包含数字、小写字母、和美元符号 '$' 。如果单词的形式为美元符号后跟着一个非负实数，那么这个单词就表示一个 价格 。
 * 例如 "$100"、"$23" 和 "$6" 表示价格，而 "100"、"$" 和 "$1e5 不是。
 * 给你一个字符串 sentence 表示一个句子和一个整数 discount 。对于每个表示价格的单词，都在价格的基础上减免 discount% ，并 更新 该单词到句子中。所有更新后的价格应该表示为一个 恰好保留小数点后两位 的数字。
 * 返回表示修改后句子的字符串。
 * 注意：所有价格 最多 为  10 位数字。
 *
 * @author jd95288
 * @date 2024-06-18 0:39
 */
public class DiscountPrices2288 {

    public String discountPrices(String sentence, int discount) {
        double mul = (100 - discount) / 100.0;
        DecimalFormat df = new DecimalFormat("0.00");
        int n = sentence.length();
        boolean skip = false;
        StringBuilder sb = new StringBuilder();
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = sentence.charAt(i);
            if (c != '$' || num.length() > 0) {
                if (!skip) {
                    sb.append(c);
                } else {
                    if (c >= '0' && c <= '9') {
                        num.append(c);
                    } else if (c == ' ' && num.length() > 0) {
                        long origin = Long.parseLong(num.toString());
                        double discnt = origin * mul;
                        sb.append(df.format(discnt)).append(c);
                        num = new StringBuilder();
                        skip = false;
                    } else {
                        sb.append(num).append(c);
                        num = new StringBuilder();
                        skip = false;
                    }
                }
            } else if (i == 0 || sentence.charAt(i - 1) == ' ') {
                skip = true;
                sb.append(c);
            } else {
                if (skip) {
                    skip = false;
                }
                sb.append(c);
            }
        }
        if (num.length() > 0) {
            long origin = Long.parseLong(num.toString());
            double discnt = origin * mul;
            sb.append(df.format(discnt));
        }
        return sb.toString();
    }
}
