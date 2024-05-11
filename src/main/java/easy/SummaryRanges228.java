package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 汇总区间
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 * <p>
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。
 * 也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *
 * @author jd95288
 * @date 2024-05-11 9:37
 */
public class SummaryRanges228 {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        int start = nums[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || nums[i + 1] - nums[i] != 1) {
                if (start != nums[i]) {
                    sb.append(start).append("->").append(nums[i]);
                    res.add(sb.toString());
                    sb.delete(0, sb.length());
                } else {
                    res.add(String.valueOf(nums[i]));
                }
                if (i < n - 1) {
                    start = nums[i + 1];
                }
            }
        }
        return res;
    }

}
