package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 找出可整除性得分最大的整数
 * <p>
 * 给你两个下标从 0 开始的整数数组 nums 和 divisors 。
 * divisors[i] 的 可整除性得分 等于满足 nums[j] 能被 divisors[i] 整除的下标 j 的数量。
 * 返回 可整除性得分 最大的整数 divisors[i] 。如果有多个整数具有最大得分，则返回数值最小的一个。
 *
 * @author jd95288
 * @date 2024-05-18 10:10
 */
public class MaxDivScore2644 {

    public int maxDivScore(int[] nums, int[] divisors) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        int maxNum = 0;
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
            maxNum = Math.max(maxNum, num);
        }
        int res = 0, maxCnt = -1;
        for (int divisor : divisors) {
            int cnt = 0;
            int num = divisor;
            for (int i = 2; num <= maxNum; i++) {
                if (cntMap.containsKey(num)) {
                    cnt += cntMap.get(num);
                }
                num = i * divisor;
            }
            if (cnt > maxCnt || (cnt == maxCnt && res > divisor)) {
                maxCnt = cnt;
                res = divisor;
            }
        }
        return res;
    }

}
