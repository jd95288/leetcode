package medium;


/**
 * 收集垃圾的最少总时间
 * 给你一个下标从 0 开始的字符串数组 garbage ，其中 garbage[i] 表示第 i 个房子的垃圾集合。
 * garbage[i] 只包含字符 'M' ，'P' 和 'G' ，但可能包含多个相同字符，每个字符分别表示一单位的金属、纸和玻璃。
 * 垃圾车收拾 一 单位的任何一种垃圾都需要花费 1 分钟。
 * <p>
 * 同时给你一个下标从 0 开始的整数数组 travel ，其中 travel[i] 是垃圾车从房子 i 行驶到房子 i + 1 需要的分钟数。
 * 城市里总共有三辆垃圾车，分别收拾三种垃圾。每辆垃圾车都从房子 0 出发，按顺序 到达每一栋房子。
 * 但它们 不是必须 到达所有的房子。
 * 任何时刻只有 一辆 垃圾车处在使用状态。当一辆垃圾车在行驶或者收拾垃圾的时候，另外两辆车 不能 做任何事情。
 * <p>
 * 请你返回收拾完所有垃圾需要花费的 最少 总分钟数。
 *
 * @author jd95288
 * @date 2024-05-11 8:37
 */
public class GarbageCollection2391 {

    public int garbageCollection(String[] garbage, int[] travel) {
        int res = 0;
        int n = garbage.length;
        int[] m = new int[n];
        int[] p = new int[n];
        int[] g = new int[n];
        for (char c : garbage[0].toCharArray()) {
            if (c == 'M') {
                m[0]++;
            } else if (c == 'P') {
                p[0]++;
            } else if (c == 'G') {
                g[0]++;
            }
        }
        int mEnd = 0;
        int pEnd = 0;
        int gEnd = 0;
        for (int i = 1; i < n; i++) {
            char[] chars = garbage[i].toCharArray();
            for (char c : chars) {
                if (c == 'M') {
                    m[i]++;
                } else if (c == 'P') {
                    p[i]++;
                } else if (c == 'G') {
                    g[i]++;
                }
            }
            m[i] += m[i - 1];
            p[i] += p[i - 1];
            g[i] += g[i - 1];
            if (m[i] != m[i - 1]) {
                mEnd = i;
            }
            if (p[i] != p[i - 1]) {
                pEnd = i;
            }
            if (g[i] != g[i - 1]) {
                gEnd = i;
            }
        }
        res += m[mEnd] + p[pEnd] + g[gEnd];
        for (int i = 1; i <= mEnd; i++) {
            res += travel[i - 1];
        }
        for (int i = 1; i <= pEnd; i++) {
            res += travel[i - 1];
        }
        for (int i = 1; i <= gEnd; i++) {
            res += travel[i - 1];
        }
        return res;
    }
}
