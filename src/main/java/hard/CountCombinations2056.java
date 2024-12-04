package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 棋盘上有效移动组合的数目
 * <p>
 * 有一个 8 x 8 的棋盘，行列编号从 1 ~ 8。
 * 棋盘上有 n 个棋子，pieces[i] 表示棋子 i 的类型，rook 表示车，queen 表示皇后，bishop 表示象，
 * positions[i] = [ri, ci] 表示棋子 i 所在行编号为 ri，所在列编号为 ci。
 * 棋盘上的每个棋子都可以移动 **至多** 一步，不同的棋子移动方式不同，参考国际象棋。
 * 车走竖线或横线，象走斜线，皇后走竖线、横线或斜线，不能跳过其它棋子。
 * 这里面还有一个时刻的概念，所有棋子从时刻 0 开始移动，每一秒每个棋子向其选择的方向移动一步直到到达目标位置。
 * 也就是说路径可能有交集，但是棋子可能并不会碰到。除非棋子的终点在另一个棋子的行进路径上，这时是无法通行的。
 *
 * @author jd95288
 * @date 2024-12-04 14:24
 */
public class CountCombinations2056 {

    public static class Move {
        public int x;
        public int y;
        public int dx;
        public int dy;
        public int step;

        public Move(int x, int y, int dx, int dy, int step) {
            this.x = x;
            this.y = y;
            this.dx = dx;
            this.dy = dy;
            this.step = step;
        }
    }

    public int[][] rookDir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[][] bishopDir = new int[][]{{-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
    public int[][] queenDir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};


    public int countCombinations(String[] pieces, int[][] positions) {
        int n = pieces.length;
        Move[][] moves = new Move[n][];
        for (int i = 0; i < n; i++) {
            moves[i] = generateAllValidMove(pieces[i], positions[i]);
        }
        Move[] curMove = new Move[n];
        return dfs(0, n, curMove, moves);
    }

    public int dfs(int i, int n, Move[] curMove, Move[][] moves) {
        if (i == n) {
            return 1;
        }
        int cnt = 0;
        here:
        for (Move move : moves[i]) {
            for (int j = 0; j < i; j++) {
                if (!valid(move, curMove[j])) {
                    continue here;
                }
            }
            curMove[i] = move;
            cnt += dfs(i + 1, n, curMove, moves);
        }
        return cnt;
    }

    public boolean valid(Move move, Move curMove) {
        int x1 = move.x;
        int y1 = move.y;
        int x2 = curMove.x;
        int y2 = curMove.y;
        for (int i = 0; i < Math.max(move.step, curMove.step); i++) {
            if (i < move.step) {
                x1 += move.dx;
                y1 += move.dy;
            }
            if (i < curMove.step) {
                x2 += curMove.dx;
                y2 += curMove.dy;
            }
            if (x1 == x2 && y1 == y2) {
                return false;
            }
        }
        return true;
    }

    public Move[] generateAllValidMove(String pieces, int[] positions) {
        int[][] directions = null;
        switch (pieces) {
            case "rook":
                directions = rookDir;
                break;
            case "bishop":
                directions = bishopDir;
                break;
            case "queen":
                directions = queenDir;
                break;
            default:
        }
        if (directions == null) {
            return null;
        }
        List<Move> moves = new ArrayList<>();
        int x = positions[0];
        int y = positions[1];
        moves.add(new Move(x, y, 0, 0, 0));
        for (int[] dir : directions) {
            int dx = dir[0];
            int dy = dir[1];
            int step = 0;
            x = positions[0] + dx;
            y = positions[1] + dy;
            while (x > 0 && x <= 8 && y > 0 && y <= 8) {
                moves.add(new Move(positions[0], positions[1], dx, dy, ++step));
                x += dx;
                y += dy;
            }
        }
        return moves.toArray(new Move[0]);
    }

    public static void main(String[] args) {
        CountCombinations2056 main = new CountCombinations2056();
//        System.out.println(main.countCombinations(new String[]{"rook"}, new int[][]{{1, 1}}));
        System.out.println(main.countCombinations(new String[]{"rook", "rook"}, new int[][]{{1, 1}, {8, 8}}));
    }
}
