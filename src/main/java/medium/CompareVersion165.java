package medium;

/**
 * 比较版本号
 * <p>
 * 给你两个 版本号字符串 version1 和 version2 ，请你比较它们。版本号由被点 '.' 分开的修订号组成。修订号的值 是它 转换为整数 并忽略前导零。
 * 比较版本号时，请按 从左到右的顺序 依次比较它们的修订号。如果其中一个版本字符串的修订号较少，则将缺失的修订号视为 0。
 * 返回规则如下：
 * 如果 version1 < version2 返回 -1，
 * 如果 version1 > version2 返回 1，
 * 除此之外返回 0。
 *
 * @author jd95288
 * @date 2025-09-23 8:49
 */
public class CompareVersion165 {

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int n = Math.max(v1.length, v2.length);
        for (int i = 0; i < n; i++) {
            int i1 = 0;
            int i2 = 0;
            if (i < v1.length) {
                i1 = Integer.parseInt(v1[i]);
            }
            if (i < v2.length) {
                i2 = Integer.parseInt(v2[i]);
            }
            if (i1 > i2) {
                return 1;
            } else if (i1 < i2) {
                return -1;
            }
        }
        return 0;
    }
}
