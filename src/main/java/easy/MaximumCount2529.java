package easy;

import java.util.Arrays;

/**
 * 正整数和负整数的最大计数
 * 给你一个按 非递减顺序 排列的数组 nums ，返回正整数数目和负整数数目中的最大值。
 * 换句话讲，如果 nums 中正整数的数目是 pos ，而负整数的数目是 neg ，返回 pos 和 neg二者中的最大值。
 * 注意：0 既不是正整数也不是负整数。
 *
 * @author jd95288
 * @date 2024-04-09 1:33
 */
public class MaximumCount2529 {

    /**
     * 二分查找
     */
    public int maximumCount_v2(int[] nums) {
        int neg = bs(nums, 0);
        int pos = bs(nums, 1);
        return Math.max(neg, nums.length - pos);
    }

    public int bs(int[] nums, int key) {
        int low = 0, high = nums.length;
        while (low != high) {
            int middle = (low + high) >> 1;
            if (nums[middle] >= key) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }
        return low;
    }

    public int maximumCount(int[] nums) {
        int pos = 0;
        int neg = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                neg++;
            } else if (nums[i] > 0) {
                pos = nums.length - i;
                break;
            }
        }
        return Math.max(pos, neg);
    }

}
