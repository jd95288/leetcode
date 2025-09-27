package easy;


/**
 * 最大三角形面积
 * <p>
 * 给你一个由 X-Y 平面上的点组成的数组 points ，其中 points[i] = [xi, yi] 。
 * 从其中取任意三个不同的点组成三角形，返回能组成的最大三角形的面积。与真实值误差在 10^-5 内的答案将会视为正确答案。
 *
 * @author jd95288
 * @date 2025-09-27 21:35
 */
public class LargestTriangleArea812 {

    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double res = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int x1 = points[i][0];
                    int y1 = points[i][1];
                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    int x3 = points[k][0];
                    int y3 = points[k][1];
                    res = Math.max(res, Math.abs(1 / 2.0 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2))));
                }
            }
        }
        return res;
    }
}
