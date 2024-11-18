package easy;


/**
 * 图片平滑器
 * <p>
 * 图像平滑器 是大小为 3 x 3 的过滤器，用于对图像的每个单元格平滑处理，平滑处理后单元格的值为该单元格的平均灰度。
 * 每个单元格的  平均灰度 定义为：该单元格自身及其周围的 8 个单元格的平均值，结果需向下取整。
 * （即，需要计算蓝色平滑器中 9 个单元格的平均值）。
 * 如果一个单元格周围存在单元格缺失的情况，则计算平均灰度时不考虑缺失的单元格
 * （即，需要计算红色平滑器中 4 个单元格的平均值）。
 *
 * @author jd95288
 * @date 2024-11-18 9:10
 */
public class ImageSmoother661 {

    public int[][] imageSmoother_v1(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] prefix = new int[m + 1][n + 1];
        for (int r = 1; r <= m; r++) {
            for (int c = 1; c <= n; c++) {
                prefix[r][c] = prefix[r - 1][c] + prefix[r][c - 1] - prefix[r - 1][c - 1] + img[r - 1][c - 1];
            }
        }
        for (int r = 0; r < m; r++) {
            int i = Math.min(m - 1, r + 1);
            int p = Math.max(0, r - 1);
            for (int c = 0; c < n; c++) {
                int j = Math.min(n - 1, c + 1);
                int q = Math.max(0, c - 1);
                int cnt = (i - p + 1) * (j - q + 1);
                img[r][c] = (prefix[i + 1][j + 1] - prefix[p][j + 1] - prefix[i + 1][q] + prefix[p][q]) / cnt;
            }
        }
        return img;
    }

}

