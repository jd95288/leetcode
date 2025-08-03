package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * @author jd95288
 * @date 2025-08-01 8:46
 */
public class Generate118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow);
        for (int i = 1; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<>(i + 1);
            tmp.add(1);
            List<Integer> list = res.get(i - 1);
            for (int j = 1; j < list.size(); j++) {
                tmp.add(list.get(j - 1) + list.get(j));
            }
            tmp.add(1);
            res.add(tmp);
        }
        return res;
    }

}
