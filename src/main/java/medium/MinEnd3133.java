package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组最后一个元素的最小值
 * <p>
 * 给你两个整数 n 和 x 。
 * 你需要构造一个长度为 n 的 正整数 数组 nums ，对于所有 0 <= i < n - 1 ，满足 nums[i + 1] 大于 nums[i] ，
 * 并且数组 nums 中所有元素的按位 AND 运算结果为 x 。
 * 返回 nums[n - 1] 可能的 最小 值。
 *
 * @author jd95288
 * @date 2024-08-22 10:12
 */
public class MinEnd3133 {

    public long minEnd(int n, int x) {
        List<Integer> zeroIndex = new ArrayList<>(63);
        int i = 0;
        int tmp = x;
        while (tmp > 0) {
            if ((tmp & 1) == 0) {
                zeroIndex.add(i);
            }
            tmp >>= 1;
            i++;
        }
        long res = x;
        int zeroCnt = zeroIndex.size();
        long highBitsCnt;
        if (zeroCnt == 0) {
            highBitsCnt = n - 1;
            while (highBitsCnt > 0) {
                if ((highBitsCnt & 1) == 1) {
                    res |= 1L << i;
                }
                i++;
                highBitsCnt >>= 1;
            }
            return res;
        }
        long oneLoopElementCnt = 1;
        tmp = zeroCnt;
        int base = 2;
        while (tmp > 0) {
            if ((tmp & 1) == 1) {
                oneLoopElementCnt = oneLoopElementCnt * base;
            }
            base *= base;
            tmp >>= 1;
        }
        long lowBitsCnt = n % oneLoopElementCnt - 1;
        if (lowBitsCnt == -1) {
            for (Integer index : zeroIndex) {
                res |= 1L << index;
            }
            if (n <= oneLoopElementCnt) {
                highBitsCnt = 0;
            } else {
                highBitsCnt = n / oneLoopElementCnt - 1;
            }
        } else {
            int j = 0;
            while (lowBitsCnt > 0) {
                if ((lowBitsCnt & 1) == 1) {
                    res |= 1L << zeroIndex.get(j);
                }
                j++;
                lowBitsCnt >>= 1;
            }
            if (n <= oneLoopElementCnt) {
                highBitsCnt = 0;
            } else {
                highBitsCnt = n / oneLoopElementCnt;
            }
        }

        while (highBitsCnt > 0) {
            if ((highBitsCnt & 1) == 1) {
                res |= 1L << i;
            }
            i++;
            highBitsCnt >>= 1;
        }

        return res;
    }

}
