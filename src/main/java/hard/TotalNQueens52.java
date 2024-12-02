package hard;

/**
 * N 皇后 II
 * <p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 *
 * @author jd95288
 * @date 2024-12-01 17:58
 */
public class TotalNQueens52 {

    public int res;
    public int n;
    public boolean[] colIndexSet;
    public boolean[] leftDiagonalSet;
    public boolean[] rightDiagonalSet;

    public int totalNQueens(int n) {
        this.n = n;
        colIndexSet = new boolean[n];
        leftDiagonalSet = new boolean[2 * n];
        rightDiagonalSet = new boolean[2 * n - 1];
        backTracing(0);
        return res;
    }

    public void backTracing(int row) {
        if (row == n) {
            res++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (colIndexSet[col] || leftDiagonalSet[row - col + n] || rightDiagonalSet[row + col]) {
                continue;
            }
            colIndexSet[col] = true;
            leftDiagonalSet[row - col + n] = true;
            rightDiagonalSet[row + col] = true;
            backTracing(row + 1);
            colIndexSet[col] = false;
            leftDiagonalSet[row - col + n] = false;
            rightDiagonalSet[row + col] = false;
        }
    }

}
