package easy;

import java.util.Arrays;

/**
 * 找到和最大的长度为 K 的子序列
 * <p>
 * 给你一个整数数组 nums 和一个整数 k 。你需要找到 nums 中长度为 k 的 子序列 ，且这个子序列的 和最大 。
 * 请你返回 任意 一个长度为 k 的整数子序列。
 * 子序列 定义为从一个数组里删除一些元素后，不改变剩下元素的顺序得到的数组。
 *
 * @author jd95288
 * @date 2025-06-28 9:44
 */
public class MaxSubsequence2099 {

    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{nums[i], i};
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int[] res = new int[k];
        int[][] subArr = new int[k][2];
        System.arraycopy(arr, n - k, subArr, 0, k);
        Arrays.sort(subArr, (a, b) -> a[1] - b[1]);
        for (int i = 0; i < k; i++) {
            res[i] = subArr[i][0];
        }
        return res;
    }
}
