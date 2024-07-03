package easy;

/**
 * 哈沙德数
 * <p>
 * 如果一个整数能够被其各个数位上的数字之和整除，则称之为 哈沙德数（Harshad number）。
 * 给你一个整数 x 。如果 x 是 哈沙德数 ，则返回 x 各个数位上的数字之和，否则，返回 -1 。
 *
 * @author jd95288
 * @date 2024-07-03 0:40
 */
public class SumOfTheDigitsOfHarshadNumber3099 {

    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0;
        int digit = x;
        while (digit > 0) {
            sum += digit % 10;
            digit /= 10;
        }
        return x % sum == 0 ? sum : -1;
    }

}
