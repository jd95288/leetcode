package medium;

import java.util.*;

/**
 * 从双倍数组中还原原数组
 *
 * 一个整数数组 original 可以转变成一个 双倍 数组 changed ，
 * 转变方式为将 original 中每个元素 值乘以 2 加入数组中，然后将所有元素 随机打乱 。
 * 给你一个数组 changed ，如果 changed 是 双倍 数组，那么请你返回 original数组，
 * 否则请返回空数组。original 的元素可以以 任意 顺序返回。
 *
 * @author jd95288
 * @date 2024-04-18 8:48
 */
public class FindOriginalArray2007 {

    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 == 1) {
            return new int[0];
        }
        Arrays.sort(changed);
        int originLength = n / 2;
        int[] res = new int[originLength];
        Deque<Integer> collect = new ArrayDeque<>();
        int i = 0;
        for (int j = 0; j < changed.length; j++) {
            if (collect.size() == 0 || changed[j] % 2 == 1 || !collect.peek().equals(changed[j] / 2)) {
                // offer也是一样的
                collect.add(changed[j]);
            } else {
                res[i++] = collect.poll();
            }
        }
        if (collect.size() > 0) {
            return new int[0];
        }
        return res;
    }

}
