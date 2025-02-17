package easy;

/**
 * 有序数组中出现次数超过25%的元素
 * <p>
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 * 请你找到并返回这个整数
 *
 * @author jd95288
 * @date 2025-02-17 8:41
 */
public class FindSpecialInteger1287 {

    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int left = 0, right = n / 4;
        while (right < n) {
            if (arr[right] == arr[left]) {
                return arr[left];
            }
            left++;
            right++;
        }
        return -1;
    }

}
