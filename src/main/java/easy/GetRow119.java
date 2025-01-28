package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角 II
 * <p>
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * @author jd95288
 * @date 2025-01-28 1:06
 */
public class GetRow119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        if (rowIndex == 0) {
            return res;
        }
        for (int i = 1; i <= rowIndex; i++) {
            int prev = res.get(0);
            for (int j = 1; j < res.size(); j++) {
                int cur = prev + res.get(j);
                prev = res.get(j);
                res.set(j, cur);
            }
            res.add(1);
        }
        return res;
    }

}
