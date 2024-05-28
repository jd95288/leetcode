package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出峰值
 * <p>
 * 给你一个下标从 0 开始的数组 mountain 。你的任务是找出数组 mountain 中的所有 峰值。
 * 以数组形式返回给定数组中 峰值 的下标，顺序不限 。
 * 注意：
 * 峰值 是指一个严格大于其相邻元素的元素。
 * 数组的第一个和最后一个元素 不 是峰值。
 *
 * @author jd95288
 * @date 2024-05-28 8:39
 */
public class FindPeaks2951 {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> res = new ArrayList<>();
        int n = mountain.length;
        int l = 0;
        int r = 2;
        while (r < n) {
            int i = l + 1;
            if (mountain[i] > mountain[l] && mountain[i] > mountain[r]) {
                res.add(i);
                l = r;
                r += 2;
            } else {
                l++;
                r++;
            }
        }
        return res;
    }
}
