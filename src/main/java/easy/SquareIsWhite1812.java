package easy;

/**
 * 判断国际象棋棋盘中一个格子的颜色
 *
 * @author jd95288
 * @date 2024-12-09 0:11
 */
public class SquareIsWhite1812 {

    public boolean squareIsWhite(String coordinates) {
        int x = coordinates.charAt(0) - '1';
        int y = coordinates.charAt(1) - 'a';
        return (x + y) % 2 == 1;
    }
}
