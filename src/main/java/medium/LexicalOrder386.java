package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 字典序排数
 * <p>
 * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 *
 * @author jd95288
 * @date 2025-06-08 18:15
 */
public class LexicalOrder386 {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0, j = 1; i < n; i++) {
            res.add(j);
            if (j * 10 <= n) {
                j *= 10;
            } else {
                while (j % 10 == 9 || j >= n) {
                    j /= 10;
                }
                j++;
            }
        }
        return res;
    }

}
