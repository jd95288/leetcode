package easy;


import java.util.*;

/**
 * 基于排列构建数组
 * <p>
 * 给你一个 从 0 开始的排列 nums（下标也从 0 开始）。
 * 请你构建一个 同样长度 的数组 ans ，其中，对于每个 i（0 <= i < nums.length），都满足 ans[i] = nums[nums[i]] 。返回构建好的数组 ans 。
 * 从 0 开始的排列 nums 是一个由 0 到 nums.length - 1（0 和 nums.length - 1 也包含在内）的不同整数组成的数组。
 * <p>
 * 进阶：你能在不使用额外空间的情况下解决此问题吗（即 O(1) 内存）？
 *
 * @author jd95288
 * @date 2025-05-06 8:43
 */
public class BuildArray1920 {

    public int[] buildArray(int[] nums) {
        int mask = 1023;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] | ((nums[nums[i]] & mask) << 10);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] >>= 10;
        }
        return nums;
    }

}
