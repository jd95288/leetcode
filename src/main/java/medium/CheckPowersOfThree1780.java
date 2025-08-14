package medium;

/**
 * 判断一个数字是否可以表示成三的幂的和
 * <p>
 * 给你一个整数 n ，如果你可以将 n 表示成若干个不同的三的幂之和，请你返回 true ，否则请返回 false 。
 * 对于一个整数 y ，如果存在整数 x 满足 y == 3x ，我们称这个整数 y 是三的幂。
 *
 * @author jd95288
 * @date 2025-08-14 9:54
 */
public class CheckPowersOfThree1780 {

    public boolean checkPowersOfThree(int n) {
        return dfs(1, 0, n);
    }

    public boolean dfs(int d, int num, int n) {
        if (num == n) {
            return true;
        } else if (num > n || d > n) {
            return false;
        }
        return dfs(d * 3, num, n) || dfs(d * 3, num + d, n);
    }

}
