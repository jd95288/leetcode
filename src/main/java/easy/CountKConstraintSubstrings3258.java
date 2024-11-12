package easy;

/**
 * 统计满足 K 约束的子字符串数量 I
 * <p>
 * 给你一个 二进制 字符串 s 和一个整数 k。
 * 如果一个 二进制字符串 满足以下任一条件，则认为该字符串满足 k 约束：
 * - 字符串中 0 的数量最多为 k。
 * - 字符串中 1 的数量最多为 k。
 * 返回一个整数，表示 s 的所有满足 k 约束 的 子字符串 的数量。
 *
 * @author jd95288
 * @date 2024-11-12 9:19
 */
public class CountKConstraintSubstrings3258 {

    public int countKConstraintSubstrings(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] cnt = new int[2];
        int res = 0, l = 0;
        for (int i = 0; i < n; i++) {
            cnt[chars[i] - '0']++;
            while (l <= i && cnt[0] > k && cnt[1] > k) {
                cnt[chars[l++] - '0']--;
            }
            res += i - l + 1;
        }
        return res;
    }

}
