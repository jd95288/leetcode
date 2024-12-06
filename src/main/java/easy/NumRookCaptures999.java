package easy;

/**
 * 可以被一步捕获的棋子数
 * <p>
 * 8 x 8 的棋盘上有一个白车 `R`，若干个白象 `B` 和黑卒 'P'，空格由 '.' 表示。
 * 问白车能够吃掉黑卒的数量，注意车只能吃掉同行同列四个方向上第一个遇到的黑卒。
 *
 * @author jd95288
 * @date 2024-12-06 9:05
 */
public class NumRookCaptures999 {

    public int numRookCaptures(char[][] board) {
        int res = 0;
        int rookRow = -1;
        int rookCol = -1;
        here:
        for (int i = 0; i < 8; i++) {
            char[] row = board[i];
            char last = '.';
            for (int j = 0; j < 8; j++) {
                if (row[j] == 'R') {
                    if (last == 'p') {
                        res++;
                    }
                    rookCol = j;
                    rookRow = i;
                } else if (rookCol != -1 && row[j] != '.') {
                    if (row[j] == 'p') {
                        res++;
                    }
                    break here;
                }
                if (row[j] != '.') {
                    last = row[j];
                }
            }
            if (rookCol != -1) {
                break;
            }
        }

        for (int i = rookRow - 1; i >= 0; i--) {
            if (board[i][rookCol] != '.') {
                if (board[i][rookCol] == 'p') {
                    res++;
                }
                break;
            }
        }
        for (int i = rookRow + 1; i < 8; i++) {
            if (board[i][rookCol] != '.') {
                if (board[i][rookCol] == 'p') {
                    res++;
                }
                break;
            }
        }
        return res;
    }

}
