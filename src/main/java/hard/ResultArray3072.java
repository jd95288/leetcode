package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 将元素分配到两个数组中 II
 * <p>
 * 给你一个下标从 1 开始、长度为 n 的整数数组 nums 。
 * 现定义函数 greaterCount ，使得 greaterCount(arr, val) 返回数组 arr 中 严格大于 val 的元素数量。
 * 你需要使用 n 次操作，将 nums 的所有元素分配到两个数组 arr1 和 arr2 中。在第一次操作中，将 nums[1] 追加到 arr1 。在第二次操作中，将 nums[2] 追加到 arr2 。之后，在第 i 次操作中：
 * 如果 greaterCount(arr1, nums[i]) > greaterCount(arr2, nums[i]) ，将 nums[i] 追加到 arr1 。
 * 如果 greaterCount(arr1, nums[i]) < greaterCount(arr2, nums[i]) ，将 nums[i] 追加到 arr2 。
 * 如果 greaterCount(arr1, nums[i]) == greaterCount(arr2, nums[i]) ，将 nums[i] 追加到元素数量较少的数组中。
 * 如果仍然相等，那么将 nums[i] 追加到 arr1 。
 * 连接数组 arr1 和 arr2 形成数组 result 。例如，如果 arr1 == [1,2,3] 且 arr2 == [4,5,6] ，那么 result = [1,2,3,4,5,6] 。
 * <p>
 * 返回整数数组 result 。
 *
 * @author jd95288
 * @date 2024-06-05 8:49
 */
public class ResultArray3072 {

    public static class Fenwick {
        private int[] tree;

        public Fenwick(int l) {
            tree = new int[l];
        }

        public void update(int index, int val) {
            while (index < tree.length) {
                tree[index] += val;
                index += index & -index;
            }
        }

        private int prefix(int index) {
            int sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= index & -index;
            }
            return sum;
        }

        public int prefix(int start, int end) {
            return prefix(end + 1) - prefix(start);
        }
    }

    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] sorted = new int[n];
        System.arraycopy(nums, 0, sorted, 0, n);
        Arrays.sort(sorted);
        Fenwick fenwick = new Fenwick(n + 1);
        fenwick.update(n - Arrays.binarySearch(sorted, nums[0]), 1);
        fenwick.update(n - Arrays.binarySearch(sorted, nums[1]), -1);
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for (int i = 2; i < n; i++) {
            int element = nums[i];
            // 逆序
            int index = n - Arrays.binarySearch(sorted, element);
            // 小于index
            int cnt = fenwick.prefix(index - 1);
            if (cnt > 0 || (cnt == 0 && arr1.size() <= arr2.size())) {
                arr1.add(element);
                fenwick.update(index, 1);
            } else {
                arr2.add(element);
                fenwick.update(index, -1);
            }
        }
        arr1.addAll(arr2);
        for (int i = 0; i < n; i++) {
            nums[i] = arr1.get(i);
        }
        return nums;
    }
}
