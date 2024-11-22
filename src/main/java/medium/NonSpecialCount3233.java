package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 统计不是特殊数字的数字数量
 * <p>
 * 返回给定区间 `[l, r]` 内不是特殊数字的数字个数，所谓特殊数字指除了它本身恰好有两个正因数的数字。
 *
 * @author jd95288
 * @date 2024-11-22 9:07
 */
public class NonSpecialCount3233 {

    public static int[] primes;

    static {
        List<Integer> primeList = new ArrayList<>();
        int end = (int) Math.ceil(Math.sqrt(1000000001));
        boolean[] isPrime = new boolean[end + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i <= end; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= end; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i <= end; i++) {
            if (isPrime[i]) {
                primeList.add(i);
            }
        }
        int cnt = primeList.size();
        primes = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            primes[i] = primeList.get(i);
        }
    }

    public int nonSpecialCount(int l, int r) {
        int ceilLeft = (int) Math.ceil(Math.sqrt(l));
        int right = (int) Math.sqrt(r);
        if (ceilLeft > right) {
            return r - l + 1;
        }
        int a = Arrays.binarySearch(primes, ceilLeft);
        if (a < 0) {
            a = -a - 1;
        }
        int b = Arrays.binarySearch(primes, right);
        if (b < 0) {
            b = -b - 2;
        }
        return r - l - b + a;
    }

}
