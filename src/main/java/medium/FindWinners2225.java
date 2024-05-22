package medium;

import java.util.*;

/**
 * 找出输掉零场或一场比赛的玩家
 * <p>
 * 给你一个整数数组 matches 其中 matches[i] = [winneri, loseri] 表示在一场比赛中 winneri 击败了 loseri 。
 * <p>
 * 返回一个长度为 2 的列表 answer ：
 * answer[0] 是所有 没有 输掉任何比赛的玩家列表。
 * answer[1] 是所有恰好输掉 一场 比赛的玩家列表。
 * 两个列表中的值都应该按 递增 顺序返回。
 * <p>
 * 注意：
 * 只考虑那些参与 至少一场 比赛的玩家。
 * 生成的测试用例保证 不存在 两场比赛结果 相同 。
 *
 * @author jd95288
 * @date 2024-05-22 9:03
 */
public class FindWinners2225 {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> neverLose = new TreeSet<>();
        Set<Integer> loseOnce = new TreeSet<>();
        Set<Integer> lost = new HashSet<>();
        for (int[] match : matches) {
            int win = match[0];
            int lose = match[1];
            neverLose.remove(lose);
            if (!lost.contains(win)) {
                neverLose.add(win);
            }
            if (!loseOnce.contains(lose) && !lost.contains(lose)) {
                loseOnce.add(lose);
            } else {
                loseOnce.remove(lose);
            }
            lost.add(lose);
        }
        List<Integer> winner = new ArrayList<>(neverLose);
        List<Integer> loser = new ArrayList<>(loseOnce);
        res.add(winner);
        res.add(loser);
        return res;
    }
}
