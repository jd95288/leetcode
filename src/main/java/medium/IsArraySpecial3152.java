package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 特殊数组 II
 * <p>
 * 如果数组的每一对相邻元素都是两个奇偶性不同的数字，则该数组被认为是一个 特殊数组 。
 * 有一个整数数组 nums 和一个二维整数矩阵 queries，对于 queries[i] = [fromi, toi]，请你帮助检查子数组 nums[fromi..toi] 是不是一个 特殊数组 。
 * 返回布尔数组 answer，如果 nums[fromi..toi] 是特殊数组，则 answer[i] 为 true ，否则，answer[i] 为 false 。
 *
 * @author jd95288
 * @date 2024-08-14 9:58
 */
public class IsArraySpecial3152 {

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        List<Integer> from = new ArrayList<>();
        List<Integer> to = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            if (nums[i] % 2 == nums[j] % 2) {
                from.add(j);
                to.add(i);
            }
        }
        int l = from.size();
        int[] fromArray = new int[l];
        int[] toArray = new int[l];
        for (int i = 0; i < l; i++) {
            fromArray[i] = from.get(i);
            toArray[i] = to.get(i);
        }
        int length = queries.length;
        boolean[] res = new boolean[length];
        Arrays.fill(res, true);
        for (int i = 0; i < length; i++) {
            int[] query = queries[i];
            if (query[0] == query[1]) {
                res[i] = true;
                continue;
            }
            int fromIndex = Arrays.binarySearch(fromArray, query[0]);
            if (fromIndex >= 0) {
                res[i] = false;
                continue;
            }
            int toIndex = Arrays.binarySearch(toArray, query[1]);
            if (fromIndex != toIndex) {
                res[i] = false;
            }
        }
        return res;
    }

}
