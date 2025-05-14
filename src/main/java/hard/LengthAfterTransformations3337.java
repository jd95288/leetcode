package hard;


import java.util.List;

/**
 * 字符串转换后的长度 II
 * <p>
 * 给你一个由小写英文字母组成的字符串 s，一个整数 t 表示要执行的 转换 次数，以及一个长度为 26 的数组 nums。每次 转换 需要根据以下规则替换字符串 s 中的每个字符：
 * 将 s[i] 替换为字母表中后续的 nums[s[i] - 'a'] 个连续字符。例如，如果 s[i] = 'a' 且 nums[0] = 3，则字符 'a' 转换为它后面的 3 个连续字符，结果为 "bcd"。
 * 如果转换超过了 'z'，则 回绕 到字母表的开头。例如，如果 s[i] = 'y' 且 nums[24] = 3，则字符 'y' 转换为它后面的 3 个连续字符，结果为 "zab"。
 * 返回 恰好 执行 t 次转换后得到的字符串的 长度。
 * 由于答案可能非常大，返回其对 10^9 + 7 取余的结果。
 *
 * @author jd95288
 * @date 2025-05-14 8:56
 */
public class LengthAfterTransformations3337 {

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int mod = 1000000007;
        int[] vector = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            vector[c - 'a']++;
        }
        int[][] matrix = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 1; j <= nums.get(i); j++) {
                int index = (i + j) % 26;
                matrix[i][index] = 1;
            }
        }
        int[] cnt = pow(vector, matrix, t, mod);
        int res = 0;
        for (int num : cnt) {
            res = (res + num) % mod;
        }
        return res;
    }

    public int[] pow(int[] vector, int[][] matrix, int exponent, int mod) {
        int[] res = vector;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                res = multiply(res, matrix, mod);
            }
            matrix = square(matrix, mod);
            exponent >>= 1;
        }
        return res;
    }

    public int[][] square(int[][] matrix, int mod) {
        int n = matrix.length;
        int[][] res = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                for (int i = 0; i < n; i++) {
                    res[row][col] = (int) ((res[row][col] + (long) matrix[row][i] * matrix[i][col]) % mod);
                }
            }
        }
        return res;
    }

    public int[] multiply(int[] vector, int[][] matrix, int mod) {
        int n = vector.length;
        int[] res = new int[n];
        for (int col = 0; col < n; col++) {
            for (int i = 0; i < n; i++) {
                res[col] = (int) ((res[col] + (long) vector[i] * matrix[i][col]) % mod);
            }
        }
        return res;
    }

}
