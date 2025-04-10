package hard;

import java.util.Arrays;

/**
 * 统计强大整数的数目
 * <p>
 * 给你三个整数 start ，finish 和 limit 。同时给你一个下标从 0 开始的字符串 s ，表示一个 正 整数。
 * 如果一个 正 整数 x 末尾部分是 s （换句话说，s 是 x 的 后缀），且 x 中的每个数位至多是 limit ，那么我们称 x 是 强大的 。
 * 请你返回区间 [start..finish] 内强大整数的 总数目 。
 * 如果一个字符串 x 是 y 中某个下标开始（包括 0 ），到下标为 y.length - 1 结束的子字符串，那么我们称 x 是 y 的一个后缀。
 * 比方说，25 是 5125 的一个后缀，但不是 512 的后缀。
 *
 * @author jd95288
 * @date 2025-04-10 20:19
 */
public class NumberOfPowerfulInt2999 {

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        long suffix = Long.parseLong(s);
        // suffix < start ||
        if (finish < suffix) {
            return 0L;
        }
        // 数字 123 会被转换为 [1, 2, 3]
        int[] high = Long.toString(finish).chars().map(x -> x - '0').toArray();
        int hl = high.length;
        long[] mem = new long[hl];
        int[] low = new int[hl--];
        long tmp = start;
        while (tmp > 0) {
            low[hl--] = (int) (tmp % 10);
            tmp /= 10;
        }
        Arrays.fill(mem, -1L);
        return dfs(0, low, high, true, true, mem, limit, s);
    }

    public long dfs(int index, int[] low, int[] high, boolean isLowLimit, boolean isHighLimit, long[] mem, int limit, String s) {
        if (index == high.length - s.length()) {
            boolean unaviable = false;
            if (isHighLimit) {
                StringBuilder hr = new StringBuilder();
                int tmp = index;
                while (tmp < high.length) {
                    hr.append(high[tmp++]);
                }
                unaviable = Long.parseLong(hr.toString()) < Long.parseLong(s);
            }
            if (isLowLimit) {
                StringBuilder lr = new StringBuilder();
                while (index < high.length) {
                    lr.append(low[index++]);
                }
                unaviable = unaviable || Long.parseLong(lr.toString()) > Long.parseLong(s);
            }
            return unaviable ? 0 : 1;
        }
        if (!isLowLimit && !isHighLimit && mem[index] != -1) {
            return mem[index];
        }
        long res = 0;
        int up = isHighLimit ? Math.min(high[index], limit) : limit;
        int down = isLowLimit ? low[index] : 0;

        for (int i = down; i <= up; i++) {
            res += dfs(index + 1, low, high, isLowLimit && i == low[index], isHighLimit && i == high[index], mem, limit, s);
        }

        if (!isHighLimit && !isLowLimit) {
            mem[index] = res;
        }
        return res;
    }

}
