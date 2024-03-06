package easy;

import java.util.Arrays;

/**
 * 找出数组中的 K-or 值
 * 统计nums中每个数的某一bit是否为1，如果该位为1的数字个数大于等于k，
 * 则返回的结果中，相应的bit也为1，否则为0
 *
 * @author jd95288
 * @date 2024-03-06 0:26
 */
public class FindKOr {
    public int findKOr(int[] nums, int k) {
        // 出错点，整数的取值范围是-2^31-1至2^31-1，否则后面相加会溢出
        int[] l = new int[31];
        for (int i = 0; i < 31; i++) {
            l[i] = (int) Math.pow(2.0, i);
        }
        int res = 0;
        for (int i = 0; i < l.length; i++) {
            int counter = 0;
            for (int j = 0; j < nums.length; j++) {
                // 错误点：判断条件不是大于
                // 注意 ：对于整数 x ，如果 (2^i & x) == 2^i ，则 x 中的第 i 位值为 1 ，其中 & 为按位与运算符。
                if ((nums[j] & l[i]) == l[i]) {
                    counter++;
                }
            }
            if (counter >= k) {
                res += l[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] l = new int[31];
        for (int i = 0; i < 31; i++) {
//            l[31 - i] = Integer.MAX_VALUE>>>i;
            l[i] = (int) Math.pow(2.0, i);
        }
        System.out.println(Arrays.toString(l));
        FindKOr main = new FindKOr();
        System.out.println(main.findKOr(new int[]{2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647}, 4));
    }
}
