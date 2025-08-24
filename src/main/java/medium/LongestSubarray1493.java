package medium;

/**
 * 删掉一个元素以后全为 1 的最长子数组
 * <p>
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 * 如果不存在这样的子数组，请返回 0 。
 *
 * @author jd95288
 * @date 2025-08-24 12:20
 */
public class LongestSubarray1493 {

    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int res = 0;
        int i = 0;
        while (i < n) {
            int start = i;
            while (i < n && nums[i] == 1) {
                i++;
            }
            for (int j = start; j < i; j++) {
                nums[j] = i;
            }
            if (i == start) {
                nums[i] = i;
                i++;
            }
        }
        for (int j = 0; j < n; j++) {
            res = Math.max(res, nums[j] - j + (nums[j] < n - 1 ? nums[nums[j] + 1] - nums[j] - 1 : 0));
        }
        return res == n ? n - 1 : res;
    }

}
