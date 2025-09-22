package easy;


/**
 * 最大频率元素计数
 * <p>
 * 给你一个由 正整数 组成的数组 nums 。
 * 返回数组 nums 中所有具有 最大 频率的元素的 总频率 。
 * 元素的 频率 是指该元素在数组中出现的次数。
 *
 * @author jd95288
 * @date 2025-09-22 8:48
 */
public class MaxFrequencyElements3005 {

    public int maxFrequencyElements(int[] nums) {
        int res = 0;
        int[] cnt = new int[101];
        int max = 0;
        for (int num : nums) {
            cnt[num]++;
            if (max < cnt[num]) {
                max = cnt[num];
                res = cnt[num];
            } else if (max == cnt[num]) {
                res += cnt[num];
            }
        }
        return res;
    }

}
