package medium;

/**
 * 甲板上的战舰
 * <p>
 * 给你一个大小为 m x n 的矩阵 board 表示甲板，
 * 其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，返回在甲板 board 上放置的 战舰 的数量。
 * 战舰 只能水平或者垂直放置在 board 上。
 * 换句话说，战舰只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）的形状建造，
 * 其中 k 可以是任意大小。两艘战舰之间至少有一个水平或垂直的空位分隔 （即没有相邻的战舰）。
 * <p>
 * 再解释一下题目，棋盘上放着战舰，战舰的形状是1*k或者k*1，战舰的排放规则是不能相邻，让我们统计战舰数量。
 * <p>
 * Given an m x n matrix board where each cell is a battleship 'X' or empty '.',
 * return the number of the battleships on board.
 * Battleships can only be placed horizontally or vertically on board.
 * In other words, they can only be made of the shape 1 x k (1 row, k columns) or k x 1 (k rows, 1 column),
 * where k can be of any size.
 * At least one horizontal or vertical cell separates between two battleships (i.e., there are no adjacent battleships).
 * <p>
 * 进阶：你可以实现一次扫描算法，并只使用 O(1) 额外空间，并且不修改 board 的值来解决这个问题吗？
 *
 * @author jd95288
 * @date 2024-06-11 8:40
 */
public class CountBattleships419 {

    public int countBattleships(char[][] board) {
        int res = 0;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            int j = 0;
            while (j < n) {
                if (visited[i][j]) {
                    j++;
                    continue;
                }
                if (board[i][j] == 'X') {
                    res++;
                    int k = i;
                    while (k < m && board[k][j] == 'X') {
                        visited[k][j] = true;
                        k++;
                    }
                    while (j < n && board[i][j] == 'X') {
                        visited[i][j] = true;
                        j++;
                    }
                } else {
                    j++;
                }
            }
        }

        return res;
    }
}
