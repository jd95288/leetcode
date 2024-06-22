package easy;

/**
 * 位1的个数（也被称为汉明重量）
 *
 * 编写一个函数，获取一个正整数的二进制形式并返回其二进制表达式中 位为1的个数（也被称为汉明重量）。
 *
 * @author jd95288
 * @date 2024-06-22 22:39
 */
public class HammingWeight191 {
    public int hammingWeight(int n) {
        int res = 0;
        while (n > 0) {
            if ((n & 1) == 1){
                res++;
            }
            n /= 2;
        }
        return res;
    }
}
