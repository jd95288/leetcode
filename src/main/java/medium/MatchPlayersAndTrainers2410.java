package medium;

import java.util.Arrays;

/**
 * 2410. 运动员和训练师的最大匹配数
 * <p>
 * 给你一个下标从 0 开始的整数数组 players ，其中 players[i] 表示第 i 名运动员的 能力 值，
 * 同时给你一个下标从 0 开始的整数数组 trainers ，其中 trainers[j] 表示第 j 名训练师的 训练能力值 。
 * 如果第 i 名运动员的能力值 小于等于 第 j 名训练师的能力值，那么第 i 名运动员可以 匹配 第 j 名训练师。
 * 除此以外，每名运动员至多可以匹配一位训练师，每位训练师最多可以匹配一位运动员。
 * 请你返回满足上述要求 players 和 trainers 的 最大 匹配数。
 *
 * @author jd95288
 * @date 2025-07-13 20:20
 */
public class MatchPlayersAndTrainers2410 {

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int m = players.length;
        int n = trainers.length;
        int res = 0;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (players[i] <= trainers[j]) {
                res++;
                i++;
            }
            j++;
        }
        return res;
    }

}
