package medium;

/**
 * 查询数组中元素的出现位置
 * <p>
 * 给你一个整数数组 nums ，一个整数数组 queries 和一个整数 x 。
 * 对于每个查询 queries[i] ，你需要找到 nums 中第 queries[i] 个 x 的位置，并返回它的下标。
 * 如果数组中 x 的出现次数少于 queries[i] ，该查询的答案为 -1 。
 * 请你返回一个整数数组 answer ，包含所有查询的答案。
 *
 * @author jd95288
 * @date 2024-12-27 6:40
 */
public class OccurrencesOfElement3159 {

    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == x) {
                nums[max++] = i;
            }
        }
        int length = queries.length;
        for (int i = 0; i < length; i++) {
            queries[i] = queries[i] > max ? -1 : nums[queries[i] - 1];
        }
        return queries;
    }

}
