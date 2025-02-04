package easy;


/**
 * 按奇偶排序数组 II
 * <p>
 * 给定一个非负整数数组 nums，  nums 中一半整数是 奇数 ，一半整数是 偶数 。
 * 对数组进行排序，以便当 nums[i] 为奇数时，i 也是 奇数 ；当 nums[i] 为偶数时， i 也是 偶数 。
 * 你可以返回 任何满足上述条件的数组作为答案 。
 *
 * @author jd95288
 * @date 2025-02-04 19:04
 */
public class SortArrayByParityII922 {

    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int even = 0, odd = 1;
        while (even < n && odd < n) {
            while (even < n && nums[even] % 2 == 0) {
                even += 2;
            }
            if (even >= n) {
                break;
            }
            while (odd < n && nums[odd] % 2 == 1) {
                odd += 2;
            }
            int tmp = nums[even];
            nums[even] = nums[odd];
            nums[odd] = tmp;
        }
        return nums;
    }

}
