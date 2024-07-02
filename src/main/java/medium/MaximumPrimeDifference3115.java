package medium;

/**
 * 质数的最大距离
 * <p>
 * 给你一个整数数组 nums。
 * 返回两个（不一定不同的）质数在 nums 中 下标 的 最大距离。
 *
 * @author jd95288
 * @date 2024-07-02 9:13
 */
public class MaximumPrimeDifference3115 {

    public int maximumPrimeDifference(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (!isPrimeNumber(nums[i])) {
            i++;
        }
        while (!isPrimeNumber(nums[j])) {
            j--;
        }
        return j - i;
    }

    public boolean isPrimeNumber(int num) {
        if (num == 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
