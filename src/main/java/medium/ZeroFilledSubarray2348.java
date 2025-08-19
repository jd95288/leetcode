package medium;

/**
 * 全 0 子数组的数目
 *
 * 给你一个整数数组 nums ，返回全部为 0 的 子数组 数目。
 * 子数组 是一个数组中一段连续非空元素组成的序列。
 *
 * @author jd95288
 * @date 2025-08-19 8:54
 */
public class ZeroFilledSubarray2348 {

    public long zeroFilledSubarray(int[] nums) {
        long res = 0L;
        int n = nums.length;
        int i = 0;
        while (i < n){
            if (nums[i] != 0){
                i++;
                continue;
            }
            int start = i;
            while (i < n && nums[i] == 0){
                i++;
            }
            int cnt = i - start;
            res += (1L + cnt) * cnt / 2;
        }

        return res;
    }
}
