package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 分数到小数
 * <p>
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * 如果存在多个答案，只需返回 任意一个 。
 * 对于所有给定的输入，保证 答案字符串的长度小于 10^4 。
 *
 * @author jd95288
 * @date 2025-09-24 9:13
 */
public class FractionToDecimal166 {

    public String fractionToDecimal(int numerator, int denominator) {
        long a = numerator;
        long b = denominator;
        if (a % b == 0) {
            return String.valueOf(a / b);
        }
        StringBuilder sb = new StringBuilder();
        if (a * b < 0) {
            sb.append("-");
        }
        a = Math.abs(a);
        b = Math.abs(b);
        long d = a / b;
        sb.append(d);
        long rem = a % b;
        sb.append(".");
        StringBuilder fraction = new StringBuilder();
        Map<Long, Integer> map = new HashMap<>();
        int i = 0;
        while (rem != 0) {
            if (map.get(rem) != null) {
                return sb.append(fraction.substring(0, map.get(rem)))
                        .append("(")
                        .append(fraction.substring(map.get(rem)))
                        .append(")").toString();
            }
            map.put(rem, i);
            rem *= 10;
            if (rem < b) {
                fraction.append(0);
            } else {
                d = rem / b;
                fraction.append(d);
                rem = rem % b;
            }
            i++;
        }
        return sb.append(fraction).toString();
    }

}
