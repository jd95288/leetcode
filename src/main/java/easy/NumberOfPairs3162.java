package easy;


/**
 * 优质数对的总数I
 *
 * 给你两个整数数组 nums1 和 nums2，长度分别为 n 和 m。同时给你一个正整数 k。
 * 如果 nums1[i] 可以被 nums2[j] * k 整除，则称数对 (i, j) 为 优质数对（0 <= i <= n - 1, 0 <= j <= m - 1）。
 * 返回 优质数对 的总数。
 *
 * @author jd95288
 * @date 2024-10-10 8:56
 */
public class NumberOfPairs3162 {

    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] % (nums2[j] * k) == 0){
                    res++;
                }
            }
        }
        return res;
    }

}
