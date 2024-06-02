package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 分糖果
 * <p>
 * Alice 有 n 枚糖，其中第 i 枚糖的类型为 candyType[i] 。
 * Alice 注意到她的体重正在增长，所以前去拜访了一位医生。
 * 医生建议 Alice 要少摄入糖分，只吃掉她所有糖的 n / 2 即可（n 是一个偶数）。
 * Alice 非常喜欢这些糖，她想要在遵循医生建议的情况下，尽可能吃到最多不同种类的糖。
 * 给你一个长度为 n 的整数数组 candyType ，返回： Alice 在仅吃掉 n / 2 枚糖的情况下，可以吃到糖的 最多 种类数。
 *
 * @author jd95288
 * @date 2024-06-02 9:26
 */
public class DistributeCandies575 {

    /**
     * 33ms
     * 不用再计数了与判断是否在集合中了
     */
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(candyType[i]);
        }
        return Math.min(set.size(), n / 2);
    }

}
