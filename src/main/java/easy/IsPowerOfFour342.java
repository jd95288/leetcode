package easy;

/**
 * 4的幂
 *
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4^x
 *
 * @author jd95288
 * @date 2025-08-15 8:43
 */
public class IsPowerOfFour342 {

    public boolean isPowerOfFour(int n) {
        return (n & (n - 1)) == 0 && Integer.numberOfLeadingZeros(n) % 2 == 1;
    }

    public static void main(String[] args) {
        IsPowerOfFour342 main = new IsPowerOfFour342();
        System.out.println(main.isPowerOfFour(1));
        System.out.println(main.isPowerOfFour(4));
        System.out.println(main.isPowerOfFour(16));
        System.out.println(main.isPowerOfFour(2));
        System.out.println(main.isPowerOfFour(3));
    }
}
