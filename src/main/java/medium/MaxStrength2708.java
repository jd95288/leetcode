package medium;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 一个小组的最大实力值
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums ，它表示一个班级中所有学生在一次考试中的成绩。
 * 老师想选出一部分同学组成一个 非空 小组，且这个小组的 实力值 最大，
 * 如果这个小组里的学生下标为 i0, i1, i2, ... , ik ，那么这个小组的实力值定义为 nums[i0] * nums[i1] * nums[i2] * ... * nums[ik​] 。
 * 请你返回老师创建的小组能得到的最大实力值为多少。
 *
 * @author jd95288
 * @date 2024-09-03 8:57
 */
public class MaxStrength2708 {

    public long maxStrength(int[] nums) {
        long res = 1L;
        Arrays.sort(nums);
        int n = nums.length;
        int i = n - 1;
        for (; i >= 0; i--) {
            if (nums[i] > 0) {
                res *= nums[i];
            } else if (nums[i] < 0) {
                break;
            }
        }
        int j = 0;
        boolean flag = true;
        if (i <= 0 && nums[n - 1] == 0) {
            return 0L;
        } else if (i == n - 1) {
            res = nums[0];
            flag = false;
            j = 1;
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (; j <= i; j++) {
            if (nums[j] < 0) {
                if (stack.isEmpty() && flag) {
                    stack.push(nums[j]);
                } else {
                    if (!flag) {
                        res *= nums[j];
                    } else {
                        res *= stack.pop() * nums[j];
                    }
                    flag = true;
                }
            }
        }
        return res;
    }

}
