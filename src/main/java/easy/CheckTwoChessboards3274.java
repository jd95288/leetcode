package easy;

/**
 * 检查棋盘方格颜色是否相同
 *
 * @author jd95288
 * @date 2024-12-03 8:58
 */
public class CheckTwoChessboards3274 {

    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        return (coordinate1.charAt(0) + coordinate1.charAt(1)) % 2 == (coordinate2.charAt(0) + coordinate2.charAt(1)) % 2;
    }

}
