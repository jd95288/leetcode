package easy;


/**
 * 将字符串拆分为若干长度为 k 的组
 * <p>
 * 字符串 s 可以按下述步骤划分为若干长度为 k 的组：
 * 第一组由字符串中的前 k 个字符组成，第二组由接下来的 k 个字符串组成，依此类推。每个字符都能够成为 某一个 组的一部分。
 * 对于最后一组，如果字符串剩下的字符 不足 k 个，需使用字符 fill 来补全这一组字符。
 * 注意，在去除最后一个组的填充字符 fill（如果存在的话）并按顺序连接所有的组后，所得到的字符串应该是 s 。
 * 给你一个字符串 s ，以及每组的长度 k 和一个用于填充的字符 fill ，按上述步骤处理之后，返回一个字符串数组，该数组表示 s 分组后 每个组的组成情况 。
 *
 * @author jd95288
 * @date 2025-06-22 12:16
 */
public class DivideString2138 {

    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        String[] res = new String[n / k + (n % k == 0 ? 0 : 1)];
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0 && i % k == 0) {
                res[j++] = sb.toString();
                sb = new StringBuilder();
            }
            sb.append(chars[i]);
        }
        int cnt = k - sb.length();
        while (cnt > 0) {
            sb.append(fill);
            cnt--;
        }
        if (j == res.length - 1) {
            res[j] = sb.toString();
        }
        return res;
    }

}
