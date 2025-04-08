package easy;

import java.util.*;

/**
 * 使数组元素互不相同所需的最少操作次数
 * <p>
 * 给你一个整数数组 nums，你需要确保数组中的元素 互不相同 。为此，你可以执行以下操作任意次：
 * 从数组的开头移除 3 个元素。如果数组中元素少于 3 个，则移除所有剩余元素。
 * 注意：空数组也视作为数组元素互不相同。返回使数组元素互不相同所需的 最少操作次数 。
 *
 * @author jd95288
 * @date 2025-04-08 8:43
 */
public class MinimumOperations3396 {

    public int minimumOperations(int[] nums) {
        int[] index = new int[101];
        Set<Integer> set = new HashSet<>();
        Arrays.fill(index, -1);
        int maxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (set.contains(num)) {
                maxIndex = Math.max(maxIndex, index[num]);
            }
            set.add(num);
            index[num] = i;
        }
        if (maxIndex == -1) {
            return 0;
        } else {
            return maxIndex / 3 + 1;
        }
    }

}
