package easy;

/**
 * 存在连续三个奇数的数组
 * <p>
 * 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。
 *
 * @author jd95288
 * @date 2025-05-11 0:15
 */
public class ThreeConsecutiveOdds1550 {

    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n - 1; i++) {
            if (arr[i - 1] % 2 == 1 && arr[i] % 2 == 1 && arr[i + 1] % 2 == 1) {
                return true;
            }
        }
        return false;
    }
}
