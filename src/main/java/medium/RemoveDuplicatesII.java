package medium;

/**
 * 删除有序数组中的重复项 II
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * @author jd95288
 * @date 2024-03-07 10:52
 */
public class RemoveDuplicatesII {

    public int removeDuplicates(int[] nums) {
        int l = 0;
        int counter = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length -1 || nums[i] != nums[i + 1]) {
                nums[l] = nums[i];
                l++;
                counter = 1;
            } else if (nums[i] == nums[i + 1] && counter < 2) {
                nums[l] = nums[i];
                l++;
                counter++;
            }
        }
        return l;
    }

}
