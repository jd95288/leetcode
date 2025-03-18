package easy;


/**
 * 对角线上的质数
 * <p>
 * 给你一个下标从 0 开始的二维整数数组 nums 。
 * 返回位于 nums 至少一条 对角线 上的最大 质数 。如果任一对角线上均不存在质数，返回 0 。
 * <p>
 * 注意：
 * 如果某个整数大于 1 ，且不存在除 1 和自身之外的正整数因子，则认为该整数是一个质数。
 * 如果存在整数 i ，使得 nums[i][i] = val 或者 nums[i][nums.length - i - 1]= val ，则认为整数 val 位于 nums 的一条对角线上。
 * 在上图中，一条对角线是 [1,5,9] ，而另一条对角线是 [3,5,7] 。
 *
 * @author jd95288
 * @date 2025-03-18 9:06
 */
public class DiagonalPrime2614 {

    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i][i] > res && isPrime(nums[i][i])) {
                res = nums[i][i];
            }
            if (nums[i][m - 1 - i] > res && isPrime(nums[i][m - 1 - i])) {
                res = nums[i][m - 1 - i];
            }
        }
        return res;
    }

    public boolean isPrime(int num) {
        // 如果小于等于 1，不是质数
        if (num <= 1) {
            return false;
        }
        // 2，3 是质数
        if (num <= 3) {
            return true;
        }
        // 2，3 的倍数不是质数
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

}
