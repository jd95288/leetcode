package medium;

/**
 * Z 字形变换
 * <p>
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 将给定字符串按 numRows 行 Z 字形排列，按从左到右、从上到下的顺序返回字符串。
 * 所谓 numRows 行 Z 字形不如说称是 numsRows 行 N 字形。
 *
 * @author jd95288
 * @date 2024-12-21 16:38
 */
public class Convert6 {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int n = s.length();
        char[] chars = new char[n];
        int k = 0;
        for (int i = 0; i < numRows; i++) {
            int[] gap;
            if (i == 0 || i == numRows - 1) {
                gap = new int[]{numRows - 1, numRows - 1};
            } else {
                gap = new int[]{i, numRows - i - 1};
            }
            int index = i;
            int j = 0;
            while (index < n) {
                chars[k++] = s.charAt(index);
                j ^= 1;
                index += 2 * gap[j];
            }
        }
        return new String(chars);
    }


}
