package easy;

/**
 * 将日期转换为二进制表示
 *
 * 给你一个字符串 date，它的格式为 yyyy-mm-dd，表示一个公历日期。
 * date 可以重写为二进制表示，只需要将年、月、日分别转换为对应的二进制表示（不带前导零）并遵循 year-month-day 的格式。
 * 返回 date 的 二进制 表示。
 *
 * @author jd95288
 * @date 2025-01-01 18:53
 */
public class ConvertDateToBinary3280 {

    public String convertDateToBinary(String date) {
        return new StringBuilder().append(Integer.toBinaryString(Integer.parseInt(date.substring(0,4))))
                .append("-")
                .append(Integer.toBinaryString(Integer.parseInt(date.substring(5,7))))
                .append("-")
                .append(Integer.toBinaryString(Integer.parseInt(date.substring(8,10)))).toString();
    }

}
