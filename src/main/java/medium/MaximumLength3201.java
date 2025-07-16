package medium;

/**
 * 找出有效子序列的最大长度I
 * <p>
 * 给你一个整数数组 nums。
 * nums 的子序列 sub 的长度为 x ，如果其满足以下条件，则称其为 有效子序列：
 * (sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2
 * 返回 nums 的 最长的有效子序列 的长度。
 * 一个 子序列 指的是从原数组中删除一些元素（也可以不删除任何元素），剩余元素保持原来顺序组成的新数组。
 *
 * @author jd95288
 * @date 2025-07-16 8:43
 */
public class MaximumLength3201 {

    public int maximumLength(int[] nums) {
        int res = 0;
        for (int a = 0; a <= 1; a++) {
            for (int b = 0; b <= 1; b++) {
                int l = 0;
                int[] p = new int[]{a, b};
                int k = 0;
                for (int num : nums) {
                    if (num % 2 == p[k]) {
                        l++;
                        k ^= 1;
                    }
                }
                res = Math.max(l, res);
            }
        }
        return res;
    }

}
