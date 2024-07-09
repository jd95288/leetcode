package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 最小化曼哈顿距离
 * <p>
 * 给你一个下标从 0 开始的数组 points ，它表示二维平面上一些点的整数坐标，其中 points[i] = [xi, yi] 。
 * 两点之间的距离定义为它们的 曼哈顿距离。两个单元格 (xi, yi) 和 (xj, yj) 之间的曼哈顿距离为 |xi - xj| + |yi - yj|。
 * 请你恰好移除一个点，返回移除后任意两点之间的 最大 距离可能的 最小 值。
 *
 * @author jd95288
 * @date 2024-07-09 10:20
 */
public class MinimumDistance3102 {

    public int minimumDistance(int[][] points) {
        for (int[] point : points) {
            int u = point[0] - point[1];
            int v = point[0] + point[1];
            point[0] = u;
            point[1] = v;
        }
        int n = points.length;
        int res = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int secondMaxX = Integer.MIN_VALUE;
        int secondMinX = Integer.MAX_VALUE;
        int secondMaxY = Integer.MIN_VALUE;
        int secondMinY = Integer.MAX_VALUE;
        int maxXIndex = -1, minXIndex = -1, maxYIndex = -1, minYIndex = -1;
        List<Integer> exclude = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (points[j][0] > maxX) {
                secondMaxX = maxX;
                maxX = points[j][0];
                maxXIndex = j;
            } else if (secondMaxX < points[j][0]) {
                secondMaxX = points[j][0];
            }
            if (points[j][0] < minX) {
                secondMinX = minX;
                minX = points[j][0];
                minXIndex = j;
            }else if (secondMinX > points[j][0]) {
                secondMinX = points[j][0];
            }
            if (points[j][1] > maxY) {
                secondMaxY = maxY;
                maxY = points[j][1];
                maxYIndex = j;
            }else if (secondMaxY < points[j][1]) {
                secondMaxY = points[j][1];
            }
            if (points[j][1] < minY) {
                secondMinY = minY;
                minY = points[j][1];
                minYIndex = j;
            } else if (secondMinY > points[j][1]) {
                secondMinY = points[j][1];
            }
        }
        exclude.add(maxXIndex);
        exclude.add(minXIndex);
        exclude.add(maxYIndex);
        exclude.add(minYIndex);

        for (Integer i : exclude) {
            int dx = (i == maxXIndex ? secondMaxX : maxX) - (i == minXIndex ? secondMinX : minX);
            int dy = (i == maxYIndex ? secondMaxY : maxY) - (i == minYIndex ? secondMinY : minY);
            res = Math.min(res, Math.max(dx, dy));
        }
        return res;
    }

}
