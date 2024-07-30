package medium;

import utils.ArrayFromFile;

import java.util.ArrayList;
import java.util.List;

/**
 * 双模幂运算
 * 给你一个下标从 0 开始的二维数组 variables ，其中 variables[i] = [ai, bi, ci, mi]，以及一个整数 target 。
 * 如果满足以下公式，则下标 i 是 好下标：
 * 0 <= i < variables.length
 * ((ai^bi % 10)^ci) % mi == target
 * 返回一个由 好下标 组成的数组，顺序不限 。
 *
 * @author jd95288
 * @date 2024-07-30 9:11
 */
public class GetGoodIndices2961 {

    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> res = new ArrayList<>();
        int n = variables.length;
        for (int i = 0; i < n; i++) {
            int[] variable = variables[i];
            int base = variable[0];
            int tmp1 = 1;
            for (int j = 0; j < variable[1]; j++) {
                tmp1 = (tmp1 * base) % 10;
            }
            base = tmp1;
            int tmp = 1;
            for (int j = 0; j < variable[2]; j++) {
                tmp = (tmp * base) % variable[3];
            }
            if (tmp % variable[3] == target) {
                res.add(i);
            }
        }
        return res;
    }

}
