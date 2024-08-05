package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 不含连续1的非负整数
 * <p>
 * 给定一个正整数 n ，请你统计在 [0, n] 范围的非负整数中，有多少个整数的二进制表示中不存在 连续的 1 。
 *
 * @author jd95288
 * @date 2024-08-05 10:20
 */
public class FindIntegers600 {

    public int findIntegers(int n) {
        List<Integer> bitmap = new ArrayList<>(32);
        while (n > 0) {
            bitmap.add(n & 1);
            n >>= 1;
        }
        int[][] mem = new int[(1 << 5) | (bitmap.size() - 1)][2];
        return dfs(0, bitmap, bitmap.size() - 1, false, mem);
    }

    public int dfs(int pre, List<Integer> bitmap, int index, boolean zeroToOne, int[][] mem) {
        int cur = bitmap.get(index);
        if (index == 0) {
            return pre == 0 && (cur == 1 || zeroToOne) ? 2 : 1;
        }
        int res = 0;
        index--;
        int size = bitmap.size();
        int key = (1 << 5) | index;
        int zto = zeroToOne ? 1 : 0;
        if (pre == 1 && cur == 1) {
            if (mem[index][1] == 0) {
                mem[index][1] = dfs(cur - 1, bitmap, index, true, mem);
            }
            res = mem[index][1];
        } else if (pre == 0 && cur == 1) {
            if (mem[index][1] == 0) {
                mem[index][1] = dfs(cur - 1, bitmap, index, true, mem);
            }
            if (mem[key][zto] == 0) {
                mem[key][zto] = dfs(cur, bitmap, index, zeroToOne, mem);
            }
            res = mem[index][1] + mem[key][zto];
        } else if (pre == 0 && cur == 0) {
            if (mem[index][zto] == 0) {
                mem[index][zto] = dfs(cur, bitmap, index, zeroToOne, mem);
            }
            res = mem[index][zto];
            if (zeroToOne) {
                if (mem[key][zto] == 0) {
                    mem[key][zto] = dfs(cur + 1, bitmap, index, zeroToOne, mem);
                }
                res += mem[key][zto];
            }
        } else {
            if (mem[index][zto] == 0) {
                mem[index][zto] = dfs(cur, bitmap, index, zeroToOne, mem);
            }
            res = mem[index][zto];
        }
        return res;
    }

}
