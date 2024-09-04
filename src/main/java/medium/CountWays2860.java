package medium;

import utils.TurnArrayToList;

import java.util.List;

/**
 * 让所有学生保持开心的分组方法数
 * <p>
 * 给你一个下标从 0 开始、长度为 n 的整数数组 nums ，其中 n 是班级中学生的总数。
 * 班主任希望能够在让所有学生保持开心的情况下选出一组学生：
 * <p>
 * 如果能够满足下述两个条件之一，则认为第 i 位学生将会保持开心：
 * 这位学生被选中，并且被选中的学生人数 严格大于 nums[i] 。
 * 这位学生没有被选中，并且被选中的学生人数 严格小于 nums[i] 。
 * <p>
 * 返回能够满足让所有学生保持开心的分组方法的数目。
 *
 * @author jd95288
 * @date 2024-09-04 10:29
 */
public class CountWays2860 {

    /**
     * 执行通过
     */
    public int countWays(List<Integer> nums) {
        int n = nums.size();
        int[] cnt = new int[n];
        for (Integer num : nums) {
            cnt[num]++;
        }
        int[] prefix = new int[n];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + cnt[i];
        }
        int res = cnt[0] > 0 ? 0 : 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += cnt[i];
            if (sum > i && cnt[i] != 0 && prefix[Math.min(n - 1, sum)] == prefix[i]) {
                res++;
            }
        }
        return res;
    }

}
