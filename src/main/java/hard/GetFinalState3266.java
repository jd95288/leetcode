package hard;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * K 次乘运算后的最终数组 II
 * <p>
 * 给你一个整数数组 nums ，一个整数 k  和一个整数 multiplier 。
 * <p>
 * 你需要对 nums 执行 k 次操作，每次操作中：
 * 找到 nums 中的 最小 值 x ，如果存在多个最小值，选择最 前面 的一个。
 * 将 x 替换为 x * multiplier 。
 * k 次操作以后，你需要将 nums 中每一个数值对 10^9 + 7 取余。
 * <p>
 * 请你返回执行完 k 次乘运算以及取余运算之后，最终的 nums 数组。
 *
 * @author jd95288
 * @date 2024-12-14 10:31
 */
public class GetFinalState3266 {

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if (multiplier == 1) {
            return nums;
        }
        int mod = 1000000007;
        int n = nums.length;
        long[] mul = new long[n];
        for (int i = 0; i < n; i++) {
            mul[i] = nums[i];
        }
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> {
            long compare = mul[a] - mul[b];
            if (compare != 0) {
                return (int) compare;
            }
            return a - b;
        });
        long max = 0;
        for (int i = 0; i < n; i++) {
            q.offer(i);
            max = Math.max(max, nums[i]);
        }
        int i = 0;
        for (; i < k; i++) {
            if (mul[q.peek()] * (long) multiplier > max) {
                break;
            }
            Integer index = q.poll();
            mul[index] = mul[index] * multiplier;
            q.offer(index);
        }
        int remainder = k - i;
        if (remainder >= n) {
            long pow = pow(multiplier, remainder / n);
            for (int j = 0; j < n; j++) {
                Integer index = q.poll();
                int rem = remainder % n;
                mul[index] = (int) ((mul[index] * pow % mod * (j < rem ? (long) multiplier : 1)) % mod);
            }
        } else {
            for (int j = 0; j < remainder; j++) {
                Integer index = q.poll();
                mul[index] = (int) ((mul[index] * (long) multiplier) % mod);
                q.offer(index);
            }
        }

        for (int j = 0; j < n; j++) {
            nums[j] = (int) mul[j];
        }
        return nums;
    }

    public long pow(long base, int power) {
        long res = 1;
        int mod = 1000000007;
        while (power > 0) {
            if ((power & 1) == 1) {
                res = res * base % mod;
            }
            base = base * base % mod;
            power >>= 1;
        }
        return res;
    }

}
