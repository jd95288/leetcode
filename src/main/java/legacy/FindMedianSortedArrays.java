package legacy;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *  
 * <p>
 * 提示：
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 * @author liyang
 * @date 2021-12-13 11:17
 */
public class FindMedianSortedArrays {

    /**
     * 执行结果：通过
     * 执行用时：2 ms, 在所有 Java 提交中击败了95.90%的用户
     * 内存消耗：39.7 MB, 在所有 Java 提交中击败了45.82%的用户
     * 通过测试用例：2094 / 2094
     * 这个问题的特征是两个数组本来就有序
     * 考虑如果排序
     * 时间复杂度为O(m+n)？
     * O(log (m+n))怎么实现？
     * */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //1 <= m + n <= 2000, nums1与nums2不能同时为空
        if (nums1 == null || nums1.length == 0) {
            return calculateMedian(nums2);
        } else if (nums2 == null || nums2.length == 0) {
            return calculateMedian(nums1);
        }
        int[] all = new int[nums1.length + nums2.length];
        int i = 0, j = 0, cur = 0;
        boolean end;
        // 核心就是如何在一个大循环里同时遍历两个集合
        while (cur < all.length) {
            end = i >= nums1.length;
            //防止nums1最大小于nums2最小时，nums1先循环完，然后数组越界
            i = i >= nums1.length ? nums1.length - 1 : i;
            //这里是大于等于，等号不能少否则会漏掉最后nums2中相等的数,并且需要保证nums2不越界j < nums2.length
            while (j < nums2.length && (nums1[i] >= nums2[j] || end)) {
                //这种不能解决nums1完全小于nums2的情况
                all[cur] = nums2[j];
                j++;
                cur++;
            }
            // 这里加这个!end判断是因为上面为了防止数组越界修改了i的值为nums1.length - 1
            if (i < nums1.length && !end) {
                all[cur] = nums1[i];
                i++;
            }
            cur++;
        }
        return calculateMedian(all);
    }

    public static double calculateMedian(int[] nums) {
        if (nums.length % 2 == 0) {
            //这里数组下标应该是length/2和length/2-1
            return (double) (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2;
        } else {
            return nums[nums.length / 2];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2};
        int[] b = new int[]{3,4};
        System.out.println(findMedianSortedArrays(a, b));
    }
}
