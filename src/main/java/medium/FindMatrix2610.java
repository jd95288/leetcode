package medium;

import java.util.*;

/**
 * 转换二维数组
 * <p>
 * 给你一个整数数组 nums 。请你创建一个满足以下条件的二维数组：
 * 二维数组应该 只 包含数组 nums 中的元素。
 * 二维数组中的每一行都包含 不同 的整数。
 * 二维数组的行数应尽可能 少 。
 * 返回结果数组。如果存在多种答案，则返回其中任何一种。
 * 请注意，二维数组的每一行上可以存在不同数量的元素。
 *
 * @author jd95288
 * @date 2025-03-19 0:21
 */
public class FindMatrix2610 {

    public List<List<Integer>> findMatrix_v1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!map.isEmpty()) {
            res.add(new ArrayList<>());
            List<Integer> list = res.get(res.size() - 1);
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                list.add(entry.getKey());
                entry.setValue(entry.getValue() - 1);
                if (entry.getValue() == 0) {
                    iterator.remove();
                }
            }
        }
        return res;
    }

}
