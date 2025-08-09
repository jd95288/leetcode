package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 2 的幂
 * <p>
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 如果存在一个整数 x 使得 n == 2^x ，则认为 n 是 2 的幂次方。
 *
 * @author jd95288
 * @date 2025-08-09 20:33
 */
public class IsPowerOfTwo231 {

    static Set<Integer> set = new HashSet<>();

    static {
        for (int i = 0; i < 31; i++) {
            set.add(1 << i);
        }
    }

    public boolean isPowerOfTwo(int n) {
        return set.contains(n);
    }

}
