package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到稳定山的下标
 * <p>
 * 返回数组的稳定下标，如果一个元素的左侧相邻元素严格大于 threshold 称当前元素是稳定的。
 *
 * @author jd95288
 * @date 2024-12-19 21:50
 */
public class StableMountains3285 {

    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> res = new ArrayList<>();
        int prev = height[0];
        int n = height.length;
        for (int i = 1; i < n; i++) {
            if (prev > threshold) {
                res.add(i);
            }
            prev = height[i];
        }
        return res;
    }
}
