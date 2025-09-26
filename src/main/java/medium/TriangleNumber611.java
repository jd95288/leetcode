package medium;

import java.util.Arrays;

/**
 * 有效三角形的个数
 * <p>
 * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 *
 * @author jd95288
 * @date 2025-09-26 8:52
 */
public class TriangleNumber611 {

    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int t = nums[i] + nums[j];
                int index = bs(nums, j, t);
                res += Math.max(0, index - j);
            }
        }
        return res;
    }

    public int bs(int[] nums, int l, int target) {
        int r = nums.length - 1;
        int m = l + (r - l) / 2;
        while (l <= r) {
            if (nums[m] >= target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
            m = l + (r - l) / 2;
        }
        return r;
    }

}
