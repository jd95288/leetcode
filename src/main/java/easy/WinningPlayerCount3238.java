package easy;

/**
 * 求出胜利玩家的数目
 *
 * 有 n 个玩家，pick[i][j] 表示玩家 i 捡起了颜色为 j 的球，
 * 如果玩家 i 捡起同一颜色球的数量大于 i 则胜出，求胜出玩家的总数。
 *
 * @author jd95288
 * @date 2024-11-23 14:17
 */
public class WinningPlayerCount3238 {

    public int winningPlayerCount(int n, int[][] pick) {
        int[][] playerBall = new int[n][11];
        for (int i = 0; i < pick.length; i++) {
            playerBall[pick[i][0]][pick[i][1]]++;
        }
        int res = 0;
        for (int i = 0; i < playerBall.length; i++) {
            for (int j = 0; j < playerBall[i].length; j++) {
                if (playerBall[i][j] > i){
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
