package easy;

/**
 * 美丽下标对的数目
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums 。
 * 如果下标对 i、j 满足 0 ≤ i < j < nums.length ，如果 nums[i] 的 第一个数字 和 nums[j] 的 最后一个数字 互质 ，
 * 则认为 nums[i] 和 nums[j] 是一组 美丽下标对 。
 * 返回 nums 中 美丽下标对 的总数目。
 * 对于两个整数 x 和 y ，如果不存在大于 1 的整数可以整除它们，则认为 x 和 y 互质 。
 * 换而言之，如果 gcd(x, y) == 1 ，则认为 x 和 y 互质，其中 gcd(x, y) 是 x 和 y 的 最大公因数 。
 *
 * @author jd95288
 * @date 2024-06-20 8:37
 */
public class CountBeautifulPairs2748 {

    public int countBeautifulPairs(int[] nums) {
        int res = 0;
        int[] firstDigitsCnt = new int[10];
        int[][] prime = new int[][]{
                {},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 3, 5, 7, 9},
                {1, 2, 4, 5, 7, 8},
                {1, 3, 5, 7, 9},
                {1, 2, 3, 4, 6, 7, 8, 9},
                {1, 5, 7},
                {1, 2, 3, 4, 5, 6, 8, 9},
                {1, 3, 5, 7, 9},
                {1, 2, 4, 5, 7, 8}
        };
        for (int num : nums) {
            for (int p : prime[num % 10]) {
                res += firstDigitsCnt[p];
            }
            while (num >= 10) {
                num /= 10;
            }
            firstDigitsCnt[num]++;
        }
        return res;
    }

}
