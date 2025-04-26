package hard;

/**
 * 统计定界子数组的数目
 * <p>
 * 给你一个整数数组 nums 和两个整数 minK 以及 maxK 。
 * nums 的定界子数组是满足下述条件的一个子数组：
 * 子数组中的 最小值 等于 minK 。
 * 子数组中的 最大值 等于 maxK 。
 * 返回定界子数组的数目。
 * 子数组是数组中的一个连续部分。
 *
 * @author jd95288
 * @date 2025-04-26 0:25
 */
public class CountSubarrays2444 {

    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int minCnt = 0, maxCnt = 0;
        int left = 0, start = 0;
        long res = 0L;
        for (int right = 0; right < n; right++) {
            if (nums[right] < minK || nums[right] > maxK) {
                left = right + 1;
                start = left;
                minCnt = 0;
                maxCnt = 0;
                continue;
            }
            if (nums[right] == minK) {
                minCnt++;
            }
            if (nums[right] == maxK) {
                maxCnt++;
            }
            while (minCnt > 0 && maxCnt > 0) {
                if (nums[left] == minK) {
                    minCnt--;
                }
                if (nums[left] == maxK) {
                    maxCnt--;
                }
                left++;
            }
            res += left - start;
        }
        return res;
    }

}
