package medium;

/**
 * 根据第K场考试的分数排序
 * <p>
 * 班里有 m 位学生，共计划组织 n 场考试。给你一个下标从 0 开始、大小为 m x n 的整数矩阵 score ，
 * 其中每一行对应一位学生，而 `score[i][j]` 表示第 i 位学生在第 j 场考试取得的分数。
 * 矩阵 score 包含的整数 互不相同 。
 * 另给你一个整数 k 。请你按第 k 场考试分数从高到低完成对这些学生（矩阵中的行）的排序。
 * 返回排序后的矩阵。
 *
 * @author jd95288
 * @date 2024-12-21 17:31
 */
public class SortTheStudents2545 {

    public int[][] sortTheStudents_v1(int[][] score, int k) {
        return sort(score, 0, score.length - 1, k);
    }

    public int[][] sort(int[][] arr, int start, int end, int k) {
        if (start == end) {
            return arr;
        }
        int mid = start + (end - start) / 2;
        sort(arr, start, mid, k);
        sort(arr, mid + 1, end, k);
        int a = start;
        int b = mid + 1;
        int i = 0;
        int[][] tmp = new int[end - start + 1][];
        while (a <= mid || b <= end) {
            int v1 = a <= mid ? arr[a][k] : Integer.MIN_VALUE;
            int v2 = b <= end ? arr[b][k] : Integer.MIN_VALUE;
            if (v1 > v2) {
                tmp[i++] = arr[a++];
            } else {
                tmp[i++] = arr[b++];
            }
        }
        for (int j = start; j <= end; j++) {
            arr[j] = tmp[j - start];
        }
        return arr;
    }
}
