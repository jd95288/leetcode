package easy;

import java.util.*;

/**
 * 找出3位偶数
 * <p>
 * 给你一个整数数组 digits ，其中每个元素是一个数字（0 - 9）。数组中可能存在重复元素。
 * 你需要找出 所有 满足下述条件且 互不相同 的整数：
 * 该整数由 digits 中的三个元素按 任意 顺序 依次连接 组成。
 * 该整数不含 前导零
 * 该整数是一个 偶数
 * 例如，给定的 digits 是 [1, 2, 3] ，整数 132 和 312 满足上面列出的全部条件。
 * 将找出的所有互不相同的整数按 递增顺序 排列，并以数组形式返回。
 *
 * @author jd95288
 * @date 2025-05-12 8:50
 */
public class FindEvenNumbers2094 {

    public int[] findEvenNumbers(int[] digits) {
        int n = digits.length;
        Set<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) {
                continue;
            }
            visited[i] = true;
            for (int j = 0; j < n; j++) {
                if (visited[j]) {
                    continue;
                }
                visited[j] = true;
                for (int k = 0; k < n; k++) {
                    if (visited[k]) {
                        continue;
                    }
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (num % 2 == 0) {
                        set.add(num);
                    }
                }
                visited[j] = false;
            }
            visited[i] = false;
        }
        int[] res = new int[set.size()];
        ArrayList<Integer> list = new ArrayList<>(set);
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        Arrays.sort(res);
        return res;
    }

}
