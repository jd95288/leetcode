package easy;

import java.util.List;

/**
 * 与车相交的点
 * <p>
 * 给你一个下标从 0 开始的二维整数数组 nums 表示汽车停放在数轴上的坐标。
 * 对于任意下标 i，nums[i] = [starti, endi] ，其中 starti 是第 i 辆车的起点，endi 是第 i 辆车的终点。
 * 返回数轴上被车 任意部分 覆盖的整数点的数目。
 *
 * @author jd95288
 * @date 2024-09-15 21:53
 */
public class NumberOfPoints2848 {

    public int numberOfPoints(List<List<Integer>> nums) {
        int[] diff = new int[102];
        for (List<Integer> segment : nums) {
            diff[segment.get(0)]++;
            diff[segment.get(1) + 1]--;
        }
        int res = 0;
        int cnt = 0;
        for (int i : diff) {
            cnt += i;
            if (cnt > 0){
                res++;
            }
        }
        return res;
    }

}
