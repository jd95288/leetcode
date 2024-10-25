package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * <p>
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 *
 * @author jd95288
 * @date 2024-10-13 21:05
 */
public class Combine77 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> stack = new ArrayList<>();
    int end;
    int k;

    /**
     * 执行通过
     */
    public List<List<Integer>> combine(int n, int k) {
        end = n;
        this.k = k;
        dfs(0);
        return res;
    }

    public void dfs(int num) {
        int d = k - stack.size();
        if (d == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        int end = this.end - d + 1;
        for (int i = num + 1; i <= end; i++) {
            stack.add(i);
            dfs(i);
            stack.remove(stack.size() - 1);
        }
    }

}
