package hard;

import java.util.*;

/**
 * N 皇后
 * <p>
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * @author jd95288
 * @date 2024-12-01 16:45
 */
public class SolveNQueens51 {

    public List<List<String>> res;
    public Set<Integer> rowIndexSet;
    public Set<Integer> colIndexSet;
    public Set<Integer> leftDiagonalSet;
    public Set<Integer> rightDiagonalSet;
    public ArrayList<int[]> indexList;
    public int end;
    public int n;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>(n);
        rowIndexSet = new HashSet<>(n);
        colIndexSet = new HashSet<>(n);
        leftDiagonalSet = new HashSet<>(n);
        rightDiagonalSet = new HashSet<>(n);
        indexList = new ArrayList<>(n);
        end = n * n;
        this.n = n;
        for (int i = 0; i < n; i++) {
            backTracing(i);
        }
        return res;
    }

    public void backTracing(int index) {
        int row = index / n;
        int col = index % n;
        int leftDiagonal = row - col;
        int rightDiagonal = row + col;
        rowIndexSet.add(row);
        colIndexSet.add(col);
        leftDiagonalSet.add(leftDiagonal);
        rightDiagonalSet.add(rightDiagonal);
        indexList.add(new int[]{row, col});
        if (indexList.size() == n) {
            StringBuilder sb = new StringBuilder();
            List<String> solution = new ArrayList<>(n);
            for (int[] cor : indexList) {
                for (int i = 0; i < n; i++) {
                    if (i == cor[1]) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                solution.add(sb.toString());
                sb.setLength(0);
            }
            res.add(solution);
        }
        for (int i = index + 1; i < end; i++) {
            int r = i / n;
            int c = i % n;
            int ld = r - c;
            int rd = r + c;
            if (rowIndexSet.contains(r) || colIndexSet.contains(c)
                    || leftDiagonalSet.contains(ld)
                    || rightDiagonalSet.contains(rd)) {
                continue;
            }
            backTracing(i);
        }
        rowIndexSet.remove(row);
        colIndexSet.remove(col);
        leftDiagonalSet.remove(leftDiagonal);
        rightDiagonalSet.remove(rightDiagonal);
        indexList.remove(indexList.size() - 1);
    }

}
