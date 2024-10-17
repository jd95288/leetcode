package easy;

import java.util.*;

/**
 * 找到小镇的法官
 * <p>
 * 小镇里有 n 个人，按从 1 到 n 的顺序编号。传言称，这些人中有一个暗地里是小镇法官。
 * 如果小镇法官真的存在，那么：
 * <p>
 * 小镇法官不会信任任何人。
 * 每个人（除了小镇法官）都信任这位小镇法官。
 * 只有一个人同时满足属性 1 和属性 2 。
 * <p>
 * 给你一个数组 trust ，其中 trust[i] = [ai, bi] 表示编号为 ai 的人信任编号为 bi 的人。
 * 如果小镇法官存在并且可以确定他的身份，请返回该法官的编号；否则，返回 -1 。
 *
 * @author jd95288
 * @date 2024-09-22 15:31
 */
public class FindJudge997 {

    public int findJudge_v2(int n, int[][] trust) {
        if (trust.length == 0) {
            return n == 1 ? 1 : -1;
        }
        int[] trustedCnt = new int[n + 1];
        int res = -1;
        for (int[] relation : trust) {
            if (++trustedCnt[relation[1]] == n - 1) {
                res = relation[1];
                break;
            }
        }
        for (int[] relation : trust) {
            if (res == relation[0]) {
                return -1;
            }
        }
        return res;
    }

}
