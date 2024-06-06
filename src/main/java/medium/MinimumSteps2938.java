package medium;

/**
 * 区分黑球与白球
 * <p>
 * 桌子上有 n 个球，每个球的颜色不是黑色，就是白色。
 * 给你一个长度为 n 、下标从 0 开始的二进制字符串 s，其中 1 和 0 分别代表黑色和白色的球。
 * 在每一步中，你可以选择两个相邻的球并交换它们。
 * 返回「将所有黑色球都移到右侧，所有白色球都移到左侧所需的 最小步数」。
 *
 * @author jd95288
 * @date 2024-06-06 0:03
 */
public class MinimumSteps2938 {
    public long minimumSteps(String s) {
        long res = 0;
        char[] chars = s.toCharArray();
        int n = chars.length;
        int i = 0;
        long cnt = 0;
        while (i < n) {
            if (chars[i] == '0') {
                res += cnt;
            } else {
                cnt++;
            }
            i++;
        }
        return res;
    }
}
