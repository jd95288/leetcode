package medium;

import java.util.*;

/**
 * 美丽子集的数目
 * <p>
 * 给你一个由正整数组成的数组 nums 和一个 正 整数 k 。
 * 如果 nums 的子集中，任意两个整数的绝对差均不等于 k ，则认为该子数组是一个 美丽 子集。
 * 返回数组 nums 中 非空 且 美丽 的子集数目。
 * nums 的子集定义为：可以经由 nums 删除某些元素（也可能不删除）得到的一个数组。只有在删除元素时选择的索引不同的情况下，两个子集才会被视作是不同的子集。
 *
 * @author jd95288
 * @date 2025-03-07 0:09
 */
public class BeautifulSubsets2597 {

    public int beautifulSubsets(int[] nums, int k) {
        return dfs(0, new ArrayList<>(), nums, k);
    }

    public int dfs(int index, List<Integer> path, int[] nums, int k) {
        if (index == nums.length) {
            return path.size() > 0 ? 1 : 0;
        }
        int res = 0;
        res += dfs(index + 1, path, nums, k);
        for (Integer num : path) {
            if (Math.abs(num - nums[index]) == k) {
                return res;
            }
        }
        path.add(nums[index]);
        res += dfs(index + 1, path, nums, k);
        path.remove(path.size() - 1);
        return res;
    }


}
