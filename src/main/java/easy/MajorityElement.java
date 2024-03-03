package easy;

/**
 * 多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * @author jd95288
 * @date 2024-03-02 22:24
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != res) {
                count--;
                if (count < 0) {
                    res = nums[i];
                    count = 1;
                }
            } else {
                count++;
            }
        }
        return res;
    }
}
