package hard;

import java.util.Arrays;

/**
 * 统计特殊整数
 * <p>
 * 如果一个正整数每一个数位都是 互不相同 的，我们称它是 特殊整数 。
 * 给你一个 正 整数 n ，请你返回区间 [1, n] 之间特殊整数的数目。
 *
 * @author jd95288
 * @date 2025-02-13 14:40
 */
public class CountSpecialNumbers2376 {

    public int countSpecialNumbers(int n) {
        int length = String.valueOf(n).length();
        int[] s = new int[length];
        int tmp = n;
        int i = length - 1;
        while (tmp > 0) {
            s[i--] = tmp % 10;
            tmp /= 10;
        }
        int[][][][] mem = new int[length + 1][1024][2][2];
        for (int[][][] digits : mem) {
            for (int[][] mask : digits) {
                for (int[] isLimit : mask) {
                    Arrays.fill(isLimit, -1);
                }
            }
        }
        return dfs(0, 0, 1, 1, mem, s);
    }

    public int dfs(int index, int mask, int isLimit, int isSkip, int[][][][] mem, int[] s) {
        if (index == s.length) {
            return 1 - isSkip;
        }
        int res = 0;
        int next = index + 1;
        if (isSkip == 1) {
            if (mem[next][mask][0][1] == -1) {
                mem[next][mask][0][1] = dfs(next, mask, 0, 1, mem, s);
            }
            res = mem[next][mask][0][1];
        }
        int up = isLimit == 1 ? s[index] : 9;
        for (int i = isSkip; i <= up; i++) {
            if ((mask >> i & 1) == 0) {
                int tmp = mask | (1 << i);
                int limit = (isLimit == 1 && i == up) ? 1 : 0;
                if (mem[next][tmp][limit][0] == -1) {
                    mem[next][tmp][limit][0] = dfs(next, tmp, limit, 0, mem, s);
                }
                res += mem[next][tmp][limit][0];
            }
        }
        return res;
    }

}
