package easy;

/**
 * 换水问题
 * <p>
 * 超市正在促销，你可以用 numExchange 个空水瓶从超市兑换一瓶水。最开始，你一共购入了 numBottles 瓶水。
 * 如果喝掉了水瓶中的水，那么水瓶就会变成空的。
 * 给你两个整数 numBottles 和 numExchange ，返回你 最多 可以喝到多少瓶水。
 *
 * @author jd95288
 * @date 2025-10-01 19:05
 */
public class NumWaterBottles1518 {

    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        while (numBottles >= numExchange) {
            int change = numBottles / numExchange;
            res += change;
            numBottles = numBottles % numExchange + change;
        }
        return res;
    }
}
