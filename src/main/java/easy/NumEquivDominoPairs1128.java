package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 等价多米诺骨牌对的数量
 * <p>
 * 给你一组多米诺骨牌 dominoes 。
 * 形式上，dominoes[i] = [a, b] 与 dominoes[j] = [c, d] 等价 当且仅当 (a == c 且 b == d) 或者 (a == d 且 b == c) 。
 * 即一张骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌。
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 *
 * @author jd95288
 * @date 2025-05-04 17:38
 */
public class NumEquivDominoPairs1128 {


    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int[] dominoe : dominoes) {
            int key = dominoe[0] << 4 | dominoe[1];
            res += map.getOrDefault(key, 0);
            map.merge(key, 1, Integer::sum);
            if (dominoe[0] != dominoe[1]) {
                map.merge(dominoe[1] << 4 | dominoe[0], 1, Integer::sum);
            }
        }
        return res;
    }

}
