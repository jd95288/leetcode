package medium;

import java.util.*;

/**
 * 正方形中的最多点数
 * <p>
 * 给你一个二维数组 points 和一个字符串 s ，其中 points[i] 表示第 i 个点的坐标，s[i] 表示第 i 个点的 标签 。
 * 如果一个正方形的中心在 (0, 0) ，所有边都平行于坐标轴，且正方形内 不 存在标签相同的两个点，那么我们称这个正方形是 合法 的。
 * 请你返回 合法 正方形中可以包含的 最多 点数。
 * 注意：
 * 如果一个点位于正方形的边上或者在边以内，则认为该点位于正方形内。
 * 正方形的边长可以为零。
 *
 * @author jd95288
 * @date 2024-08-03 21:44
 */
public class MaxPointsInsideSquare3143 {

    public int maxPointsInsideSquare(int[][] points, String s) {
        int n = points.length;
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int key = Math.max(Math.abs(points[i][0]), Math.abs(points[i][1]));
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(i);
        }
        Set<Character> labelSet = new HashSet<>();
        int res = 0;
        here:
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            for (Integer i : entry.getValue()) {
                if (labelSet.contains(s.charAt(i))) {
                    break here;
                }
                labelSet.add(s.charAt(i));
            }
            res += entry.getValue().size();
        }
        return res;
    }

}
