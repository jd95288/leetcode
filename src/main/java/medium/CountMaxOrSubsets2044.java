package medium;

/**
 * 统计按位或能得到最大值的子集数目
 * <p>
 * 给你一个整数数组 nums ，请你找出 nums 子集 按位或 可能得到的 最大值 ，
 * 并返回按位或能得到最大值的 不同非空子集的数目 。
 * 如果数组 a 可以由数组 b 删除一些元素（或不删除）得到，则认为数组 a 是数组 b 的一个 子集 。
 * 如果选中的元素下标位置不一样，则认为两个子集 不同 。
 * 对数组 a 执行 按位或 ，结果等于 a[0] OR a[1] OR ... OR a[a.length - 1]（下标从 0 开始）。
 *
 * @author jd95288
 * @date 2025-07-28 8:44
 */
public class CountMaxOrSubsets2044 {

    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max |= num;
        }
        return dfs(0, 0, nums, max);
    }

    public int dfs(int i, int or, int[] nums, int max) {
        int n = nums.length;
        if (i == n) {
            return 0;
        }
        int cur = or | nums[i];
        return dfs(i + 1, cur, nums, max) + dfs(i + 1, or, nums, max) + (cur == max ? 1 : 0);
    }

}
