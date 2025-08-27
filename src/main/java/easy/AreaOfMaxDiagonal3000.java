package easy;

/**
 * 对角线最长的矩形的面积
 *
 * 给你一个下标从 0 开始的二维整数数组 dimensions。
 * 对于所有下标 i（0 <= i < dimensions.length），dimensions[i][0] 表示矩形 i 的长度，而 dimensions[i][1] 表示矩形 i 的宽度。
 * 返回对角线最 长 的矩形的 面积 。如果存在多个对角线长度相同的矩形，返回面积最 大 的矩形的面积。
 *
 * @author jd95288
 * @date 2025-08-26 8:45
 */
public class AreaOfMaxDiagonal3000 {

    public int areaOfMaxDiagonal(int[][] dimensions) {
        int res = 0;
        int diagonal = 0;
        for (int[] dimension : dimensions) {
            int length = dimension[0];
            int width = dimension[1];
            int cur = length * length + width * width;
            if (diagonal < cur) {
                res = length * width;
                diagonal = cur;
            } else if (diagonal == cur) {
                res = Math.max(res, length * width);
            }
        }
        return res;
    }

}
